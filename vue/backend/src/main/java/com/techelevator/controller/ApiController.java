package com.techelevator.controller;

import com.techelevator.authentication.AuthProvider;
import com.techelevator.authentication.UnauthorizedException;
import com.techelevator.model.Application;
import com.techelevator.model.IApplicationDAO;
import com.techelevator.model.INotesDAO;
import com.techelevator.model.IPersonDAO;
import com.techelevator.model.Notes;
import com.techelevator.model.Person;

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
    
    public ApiController(IApplicationDAO applicationDao, IPersonDAO personDao, INotesDAO notesDao) {
    	this.applicationDao = applicationDao;
    	this.personDao = personDao;
    	this.notesDao = notesDao;
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
    	System.out.println("I am here");
    	return personDao.getAllPersonsWithApplicantId();
    }
    
    @GetMapping(path = "/applicants/{applicantId}")
    public Application getApplicantById(@PathVariable String applicantId) {
  	return applicationDao.getFullApplicationByApplicantId(Integer.parseInt(applicantId));
    }
    
    @PutMapping(path = "/applicants/{applicantId}")
    public ResponseEntity<Void> updateApplicant (@RequestBody Application application) {
    	applicationDao.updateFullApplication(application);
    	UriComponents applicationUri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/" + Integer.toString(application.getApplicationId())).build();
    	
    	return ResponseEntity.created(applicationUri.toUri()).build();
    }
    
    @PostMapping(path="/register")
    public ResponseEntity<Void> createApplicant (@RequestBody Application application) {
    	applicationDao.createNewApplication(application);
    	UriComponents applicationUri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/" + Integer.toString(application.getApplicationId())).build();
    	
    	return ResponseEntity.created(applicationUri.toUri()).build();
    }
}