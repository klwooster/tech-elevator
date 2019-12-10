package com.techelevator.model;

import java.util.List;

public interface IAccountDAO {

	
	//List of All Persons for an Account
	public List<Account> getAllPersonsForAccountId(int id);
	
}
