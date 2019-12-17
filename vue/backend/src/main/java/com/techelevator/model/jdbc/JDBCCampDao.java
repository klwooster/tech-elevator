package com.techelevator.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Camp;
import com.techelevator.model.ICampDAO;
import com.techelevator.model.Person;

@Component
public class JDBCCampDao implements ICampDAO {
	private final JdbcTemplate jdbcTemplate;
	
	public JDBCCampDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Camp> getAllCampDetails() {
		String sqlGetAllCampDetails = "SELECT camp_id, name, description, location, capacity, min_age, max_age, start_date, end_date, image FROM camp";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetAllCampDetails);
		List<Camp> camps = new ArrayList<Camp>();
		
		while(result.next()) {
			camps.add(mapRowToCamp(result));
		}
		
		return null;
	}

	@Override
	public List<Person> getAllAttendeesByCampId(int id) {
		String sqlGetAllAttendeesByCampId = "SELECT p.person_id, p.first_name, p.last_name, p.preferred_name, p.date_of_birth, p.email, p.phone, a.account_id "
										  + "FROM person p JOIN application a ON p.person_id = a.applicant_id "
										  + "WHERE a.program_id = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetAllAttendeesByCampId, id);
		List<Person> attendees = new ArrayList<Person>();
		
		while(result.next()) {
			attendees.add(mapRowToAttendee(result));
		}
		
		return attendees;
	}
	
	private Person mapRowToAttendee(SqlRowSet result) {
		Person attendee = new Person();
		
		attendee.setAccountId(result.getInt("account_id"));
		attendee.setFirstName(result.getString("first_name"));
		attendee.setLastName(result.getString("last_name"));
		attendee.setPreferredName(result.getString("preferred_name"));
		attendee.setDateOfBirth(result.getDate("date_of_birth").toLocalDate());
		attendee.setEmail(result.getString("email"));
		attendee.setPhone(result.getString("phone"));
		attendee.setPersonId(result.getInt("person_id"));
		
		return attendee;
	}

	private Camp mapRowToCamp(SqlRowSet result) {
		Camp camp = new Camp();
		
		camp.setCampId(result.getInt("camp_id"));
		camp.setName(result.getString("name"));
		camp.setDescription(result.getString("description"));
		camp.setLocation(result.getString("location"));
		camp.setTotalCapacity(result.getInt("capacity"));
		camp.setMaxAge(result.getInt("max_age"));
		camp.setMinAge(result.getInt("min_age"));
		camp.setStartDate(result.getDate("start_date").toLocalDate());
		camp.setEndDate(result.getDate("end_date").toLocalDate());
		camp.setImage(result.getString("image"));
		camp.setAttendees(getAllAttendeesByCampId(camp.getCampId()));
		
		return camp;
	}
}
