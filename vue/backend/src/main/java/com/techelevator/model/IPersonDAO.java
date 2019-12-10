package com.techelevator.model;

import java.util.List;

public interface IPersonDAO {

	//Get All Persons from Table
	public List<Person> getAllPersons();
	
	//Person by Person Id
	public Person getPersonByPersonId(int id);
}
