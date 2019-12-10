package com.techelevator.model;

import java.util.List;

public interface IPersonDAO {

	//Get All Persons from Table
	public List<Person> getAllPersons();
	
	//Get All Persons and AccountId
	public List<Person> getAllPersonsAndAccountId();
	
	//Person by Person Id
	public Person getPersonByPersonId(int id);
	
	//A Person that has an Applicant Id on Application is a Camper
	public List<Person> getAllPersonsWithApplicantId();
	
}
