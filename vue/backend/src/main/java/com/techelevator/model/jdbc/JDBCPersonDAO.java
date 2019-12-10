package com.techelevator.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Account;
import com.techelevator.model.Application;
import com.techelevator.model.IPersonDAO;
import com.techelevator.model.Person;

public class JDBCPersonDAO implements IPersonDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCPersonDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Person getPersonByPersonId(int id) {
		Person thePerson = null;
		String sqlFindPersonByPersonId = "SELECT person_id, first_name, last_name, preferred_name, date_of_birth, email, phone FROM person WHERE person_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindPersonByPersonId, id);
		if (results.next()) {
			thePerson = mapRowToPerson(results);
		}
		return thePerson;
	}
	
	
	@Override
	public List<Person> getAllPersons() {
		List<Person> personIds = new ArrayList<>();

		String sqlFindAllPersons = "SELECT person_id, first_name, last_name, preferred_name, date_of_birth, email, phone FROM person";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllPersons);

		while (results.next()) {
			Person thePerson = mapRowToPerson(results);
			personIds.add(thePerson);
		}

		return personIds;
	}
	
	@Override
	public List<Person> getAllPersonsAndAccountId() {
		List<Person> personIds = new ArrayList<>();

		String sqlFindAllPersons = "SELECT p.person_id, p.first_name, p.last_name, p.preferred_name, p.date_of_birth, p.email, p.phone, a.account_id \n" + 
				"FROM person p, account a\n" + 
				"WHERE p.person_id = a.person_id";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllPersons);

		while (results.next()) {
			Person thePerson = mapRowToPersonAndAccountId(results);
			personIds.add(thePerson);
		}

		return personIds;
	}

	private Person mapRowToPerson(SqlRowSet results) {
		Person thePerson;
		thePerson = new Person();
		thePerson.setPersonId(results.getInt("person_id"));
		thePerson.setFirstName(results.getString("first_name"));
		thePerson.setLastName(results.getString("last_name"));
		thePerson.setPreferredName(results.getString("preferred_name"));
		thePerson.setDateOfBirth(results.getString("date_of_birth"));
		thePerson.setEmail(results.getString("email"));
		thePerson.setPhone(results.getString("phone"));
		
		return thePerson;
	}
	
	private Person mapRowToPersonAndAccountId(SqlRowSet results) {
		Person thePerson;
		thePerson = new Person();
		thePerson.setPersonId(results.getInt("person_id"));
		thePerson.setFirstName(results.getString("first_name"));
		thePerson.setLastName(results.getString("last_name"));
		thePerson.setPreferredName(results.getString("preferred_name"));
		thePerson.setDateOfBirth(results.getString("date_of_birth"));
		thePerson.setEmail(results.getString("email"));
		thePerson.setPhone(results.getString("phone"));
		thePerson.setAccountId(results.getInt("account_id"));
		
		return thePerson;
	}

}
