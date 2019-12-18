package com.techelevator.model.jdbc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.IPersonDAO;
import com.techelevator.model.Person;

@Component
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
	
	@Override
	public List<Person> getAllPersonsWithApplicantId() {
		List<Person> personIds = new ArrayList<>();

		String sqlFindAllPersonsWithApplicantId = "SELECT p.person_id, p.first_name, p.last_name, p.preferred_name, p.date_of_birth, p.email, p.phone, a.account_id " + 
				"FROM person p, account a, application app " + 
				"WHERE p.person_id = a.person_id " + 
				"AND p.person_id = app.applicant_id";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllPersonsWithApplicantId);

		while (results.next()) {
			Person thePerson = mapRowToPersonAndAccountId(results);
			personIds.add(thePerson);
		}

		return personIds;
	}
	
	@Override
	public List<Person> getPersonsByProgram(String programName) {
		List<Person> people = new ArrayList<>();
		
		String sqlFindPeopleByProgram = "SELECT p.person_id, p.first_name, p.last_name, p.preferred_name, p.date_of_birth, p.email, p.phone, a.account_id " + 
										"FROM person p, account a, application app  " + 
										"WHERE p.person_id = a.person_id " + 
										"AND p.person_id = app.applicant_id " + 
										"AND app.program = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindPeopleByProgram, programName);
		while(results.next()) {
			Person thePerson = mapRowToPersonAndAccountId(results);
			people.add(thePerson);
		}
		return people;
	}
	
	@Override
	public void updatePerson(Person inputPerson) {
		
		 int person_id = inputPerson.getPersonId();
		 String first_name = inputPerson.getFirstName();
		 String last_name = inputPerson.getLastName();
		 String preferred_name = inputPerson.getPreferredName();
		 LocalDate date_of_birth = convertDate(inputPerson.getDateOfBirth());
		 String email = inputPerson.getEmail();
		 String phone = inputPerson.getPhone();
	     
		 String sqlUpdatePerson = "UPDATE person SET first_name = ?, last_name = ?, preferred_name = ?, date_of_birth = ?, email = ?, phone = ? WHERE person_id = ?";
	     jdbcTemplate.update(sqlUpdatePerson, first_name, last_name, preferred_name, date_of_birth, email, phone, person_id);
		
	}
	
	@Override
	public int createNewPerson(Person inputPerson) {
		 String first_name = inputPerson.getFirstName();
		 String last_name = inputPerson.getLastName();
		 String preferred_name = inputPerson.getPreferredName();
		 LocalDate date_of_birth = convertDate(inputPerson.getDateOfBirth());
		 String email = inputPerson.getEmail();
		 String phone = inputPerson.getPhone();

		 String sqlCreatePerson = "INSERT INTO person (first_name, last_name, preferred_name, date_of_birth, email, phone) VALUES (?,?,?,?,?,?)";
	     jdbcTemplate.update(sqlCreatePerson, first_name, last_name, preferred_name, date_of_birth, email, phone);
	     
		 String sqlCreateAccountRelationship = "INSERT INTO account (account_id, person_id) VALUES (?, ?)";
	     jdbcTemplate.update(sqlCreateAccountRelationship, inputPerson.getAccountId(), getCurrentPersonId());
	     
	     return getCurrentPersonId();
	}

	private Person mapRowToPerson(SqlRowSet results) {
		Person thePerson;
		thePerson = new Person();
		thePerson.setPersonId(results.getInt("person_id"));
		thePerson.setFirstName(results.getString("first_name"));
		thePerson.setLastName(results.getString("last_name"));
		thePerson.setPreferredName(results.getString("preferred_name"));
		thePerson.setDateOfBirth(convertDate(results.getDate("date_of_birth").toLocalDate()));
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
		thePerson.setDateOfBirth(convertDate(results.getDate("date_of_birth").toLocalDate()));
		thePerson.setEmail(results.getString("email"));
		thePerson.setPhone(results.getString("phone"));
		thePerson.setAccountId(results.getInt("account_id"));
		
		return thePerson;
	}
	
	private int getCurrentPersonId() {
		String sqlSelectNextId = "SELECT CURRVAL('person_person_id_seq')";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		int id = 0;
		if (results.next()) {
			id = results.getInt(1);
		} else {
			throw new RuntimeException("Something strange happened, unable to select next person id from sequence");
		}
		return id;
	}
	
	private LocalDate convertDate(String dateText) {
		int year = 2020;
		int month = 01;
		int day = 01;
		
		try {
		year = Integer.parseInt(dateText.substring(0, dateText.indexOf('-')));
		dateText = dateText.substring(dateText.indexOf('-') + 1);
		
		month = Integer.parseInt(dateText.substring(0, dateText.indexOf('-')));
		dateText = dateText.substring(dateText.indexOf('-') + 1);
		
		day = Integer.parseInt(dateText.substring(0, dateText.indexOf('-')));
		
			return LocalDate.of(year, month, day);
		} catch (Exception e) {
			return LocalDate.of(year, month, day);
		}
	}
	
	private String convertDate(LocalDate date) {
		try {
			return date.getYear() + "-" + date.getMonthValue() + "-" + date.getDayOfMonth();
		} catch (Exception e) {
			return "2020-01-01";
		}
	}
}
