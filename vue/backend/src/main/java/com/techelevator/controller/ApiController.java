package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.techelevator.model.HistoryLogger;
import com.techelevator.model.IApplicationDAO;
import com.techelevator.model.IHistoryChangesDAO;
import com.techelevator.model.IHistoryDAO;
import com.techelevator.model.INotesDAO;
import com.techelevator.model.IPersonDAO;
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
    IHistoryDAO historyDao;
    @Autowired
    IHistoryChangesDAO historyChangesDao;
    
    public ApiController(IApplicationDAO applicationDao, IPersonDAO personDao, INotesDAO notesDao, IHistoryDAO historyDao, IHistoryChangesDAO historyChangesDao) {
    	this.applicationDao = applicationDao;
    	this.personDao = personDao;
    	this.notesDao = notesDao;
    	this.historyDao = historyDao;
    	this.historyChangesDao = historyChangesDao;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String authorizedOnly() throws UnauthorizedException {
        /*
        You can lock down which roles are allowed by checking
        if the current user has a role.
        
        In this example, if the user does not have the admin role
        we send back an unauthorized error.
        */
        if (!authProvider.userHasRole(new String[] { "admin" })) {
            throw new UnauthorizedException();
        }
        return "Success";
    }
    
    @GetMapping(path = "/applicants")
    public List <Person> getAllPersonsWithApplicantId() {
    	
    	return personDao.getAllPersonsWithApplicantId();
    }
    
    @GetMapping(path = "/applicants/{applicantId}")
    public Application getApplicantById(@PathVariable String applicantId) {
  	return applicationDao.getFullApplicationByApplicantId(Integer.parseInt(applicantId));
    }
    
    @PutMapping(path = "/applicants/{applicantId}")
    public ResponseEntity<Void> updateApplicant (@RequestBody Application application) {
    	Application oldValues = applicationDao.getFullApplicationByApplicantId(application.getApplicantId());
    	String status = applicationDao.updateFullApplication(application);
    	UriComponents applicationUri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/" + Integer.toString(application.getApplicationId())).build();
    	HistoryLogger logger = new HistoryLogger(historyDao, historyChangesDao);
    	logger.logChanges(application, oldValues, status);
    	
    	return ResponseEntity.created(applicationUri.toUri()).build();
    }
    
    @PostMapping(path="/register")
    public ResponseEntity<Void> createApplicant (@RequestBody Application application) {
    	Application oldValues = applicationDao.getFullApplicationByApplicantId(application.getApplicantId());
    	String status = applicationDao.createNewFullApplication(application);
    	UriComponents applicationUri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/" + Integer.toString(application.getApplicationId())).build();
    	HistoryLogger logger = new HistoryLogger(historyDao, historyChangesDao);
    	logger.logChanges(application, oldValues, status);
    	
    	return ResponseEntity.created(applicationUri.toUri()).build();
    }
    
    @GetMapping(path="/history")
    public History getAccountHistory (@PathVariable int applicationId) {
    	historyDao.getHistorybyId(applicationId);
    }
    
    
}