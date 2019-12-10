package com.techelevator.model;

import java.util.List;

public interface IApplicationDAO {
	
	//Application by Application Id
	public Application getApplicationByApplicationId (int id);
	
	//List of Applications by Applicant Id
	public List<Application> getApplicationsByApplicantId(int id);
	
	//List of Applications by Account Id
	public List<Application> getApplicationsByAccountId(int id);
	
	//Full Application Data including Person data for Applicant, Guardian, Emergency Contact, and Notes
	public Application getFullApplicationByApplicantId(int id);
	
}
