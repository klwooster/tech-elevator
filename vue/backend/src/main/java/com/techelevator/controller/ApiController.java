package com.techelevator.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import com.techelevator.authentication.AuthProvider;
import com.techelevator.authentication.UnauthorizedException;
import com.techelevator.model.Application;
import com.techelevator.model.Camp;
import com.techelevator.model.ChangeStatus;
import com.techelevator.model.History;
import com.techelevator.model.HistoryLogger;
import com.techelevator.model.IApplicationDAO;
import com.techelevator.model.ICampDAO;
import com.techelevator.model.IHistoryChangesDAO;
import com.techelevator.model.IHistoryDAO;
import com.techelevator.model.INotesDAO;
import com.techelevator.model.IPersonDAO;
import com.techelevator.model.Notes;
import com.techelevator.model.Person;

/**
 * ApiController
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private AuthProvider authProvider;

	@Autowired
	private IApplicationDAO applicationDao;

	@Autowired
	private IPersonDAO personDao;

	@Autowired
	private INotesDAO notesDao;

	@Autowired
	private IHistoryDAO historyDao;

	@Autowired
	private IHistoryChangesDAO historyChangesDao;

	@Autowired
	private ICampDAO campDao;

	public ApiController(IApplicationDAO applicationDao, IPersonDAO personDao, INotesDAO notesDao,
			IHistoryDAO historyDao, IHistoryChangesDAO historyChangesDao, ICampDAO campDao) {
		this.applicationDao = applicationDao;
		this.personDao = personDao;
		this.notesDao = notesDao;
		this.historyDao = historyDao;
		this.historyChangesDao = historyChangesDao;
		this.campDao = campDao;
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String authorizedOnly() throws UnauthorizedException {
		/*
		 * You can lock down which roles are allowed by checking if the current user has
		 * a role.
		 * 
		 * In this example, if the user does not have the admin role we send back an
		 * unauthorized error.
		 */
		if (!authProvider.userHasRole(new String[] { "admin" })) {
			throw new UnauthorizedException();
		}
		return "Success";
	}

	@GetMapping(path = "/applicants")
	public List<Person> getAllPersonsWithApplicantId() {

		return personDao.getAllPersonsWithApplicantId();
	}

	@GetMapping(path = "/applicants/{applicantId}")
	public Application getApplicantById(@PathVariable String applicantId) {
		return applicationDao.getFullApplicationByApplicantId(Integer.parseInt(applicantId));
	}

	@GetMapping(path = "/camps")
	public List<Camp> getCamps() {
		return campDao.getAllCampDetails();
	}

	@PutMapping(path = "/applicants/{applicantId}")
	public ResponseEntity<String> updateApplicant(@RequestBody Application application) {
		Application oldValues = applicationDao.getFullApplicationByApplicantId(application.getApplicantId());
		ChangeStatus status = applicationDao.updateFullApplication(application);
		HistoryLogger logger = new HistoryLogger(historyDao, historyChangesDao);

		logger.logChanges(application, oldValues, status);

		if (status.getStatus().equals("Success")) {
			return new ResponseEntity<String>(String.valueOf(status.getId()), HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("New application could not be created, please try again later.",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(path = "/notes/{applicationId}")
	public List<Notes> getNotesByApplicationId(@PathVariable String applicationId) {
		return notesDao.getNotesByApplicationId(Integer.parseInt(applicationId));
	}

	@PostMapping(path = "/notes/{applicationId}")
	public ResponseEntity<Void> updateNotes(@RequestBody Notes notes, @PathVariable String applicationId) {
		notes.setApplicationId(Integer.parseInt(applicationId));
		notesDao.createNewNotes(notes);

		UriComponents uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
				.path("/" + Integer.toString(notes.getApplicationId())).build();
		return ResponseEntity.created(uri.toUri()).build();
	}

	@PostMapping(path = "/register")
	public ResponseEntity<String> createApplicant(@RequestBody Application application) {
		ChangeStatus status = applicationDao.createNewFullApplication(application);
		application.setApplicationId(status.getId());

		HistoryLogger logger = new HistoryLogger(historyDao, historyChangesDao);
		logger.logChanges(application, status);

		if (status.getStatus().equals("New Application - Success")) {
			return new ResponseEntity<String>(String.valueOf(status.getId()), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("New application could not be created, please try again later.",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(path = "/history/{applicationId}")
	public List<History> getApplicationHistory(@PathVariable int applicationId) {
		return historyDao.getHistoryByChangedId(applicationId);
	}

	@GetMapping(path = "/attendees/{programName}")
	public List<Person> getPersonsByProgram(@PathVariable String programName) {
		System.out.println("We are here");
		return personDao.getPersonsByProgram(programName);
	}
}