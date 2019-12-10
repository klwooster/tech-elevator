package com.techelevator.model.jdbc;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

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

}
