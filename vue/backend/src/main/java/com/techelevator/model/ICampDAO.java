package com.techelevator.model;

import java.util.List;

public interface ICampDAO {
	List<Camp> getAllCampDetails();
	List<Person> getAllAttendeesByCampId(int id);
}
