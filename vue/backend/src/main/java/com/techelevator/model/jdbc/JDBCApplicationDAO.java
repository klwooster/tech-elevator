package com.techelevator.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Account;
import com.techelevator.model.Application;
import com.techelevator.model.IApplicationDAO;

public class JDBCApplicationDAO implements IApplicationDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCApplicationDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Application getApplicationByApplicationId(int id) {
		Application theApplication = null;
		String sqlFindApplicationByApplicationId = "SELECT application_id, applicant_id ,account_id,guardian_id,emergency_contact_id,dietary_preference ,dietary_restrictions,mobility_issues,medical_concerns,meal_plan,program,dorm_assignment,tshirt_size FROM application WHERE application_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindApplicationByApplicationId, id);
		if (results.next()) {
			theApplication = mapRowToApplication(results);
		}
		return theApplication;
	}

	@Override
	public List<Application> getApplicationsByApplicantId(int id) {
		List<Application> applications = new ArrayList<>();

		String sqlFindApplicationsByApplicantId = "SELECT application_id, applicant_id ,account_id,guardian_id,emergency_contact_id,dietary_preference ,dietary_restrictions,mobility_issues,medical_concerns,meal_plan,program,dorm_assignment,tshirt_size FROM application WHERE applicant_id = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindApplicationsByApplicantId, id);

		while (results.next()) {
			Application theApplication = mapRowToApplication(results);
			applications.add(theApplication);
		}

		return applications;
	}

	@Override
	public List<Application> getApplicationsByAccountId(int id) {
		List<Application> applications = new ArrayList<>();

		String sqlFindApplicationsByAccountId = "SELECT application_id, applicant_id ,account_id,guardian_id,emergency_contact_id,dietary_preference ,dietary_restrictions,mobility_issues,medical_concerns,meal_plan,program,dorm_assignment,tshirt_size FROM application WHERE account_id = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindApplicationsByAccountId, id);

		while (results.next()) {
			Application theApplication = mapRowToApplication(results);
			applications.add(theApplication);
		}

		return applications;
	}
	
	private Application mapRowToApplication(SqlRowSet results) {
		Application theApplication;
		theApplication = new Application();
		theApplication.setApplicationId(results.getInt("application_id"));
		theApplication.setApplicantId(results.getInt("applicant_id"));
		theApplication.setAccountId(results.getInt("account_id"));
		theApplication.setGuardianId(results.getInt("guardian_id"));
		theApplication.setEmergencyContactId(results.getInt("emergency_contact_id"));
		theApplication.setDietaryPreference(results.getString("dietary_preference"));
		theApplication.setDietaryRestrictions(results.getString("dietary_restrictions"));
		theApplication.setMobilityIssues(results.getString("mobility_issues"));
		theApplication.setMedicalConcerns(results.getString("medical_concerns"));
		theApplication.setMealPlan(results.getString("meal_plan"));
		theApplication.setProgram(results.getString("program"));
		theApplication.setDormAssignment(results.getString("dorm_assignment"));
		theApplication.setTshirtSize(results.getString("tshirt_size"));
		
		return theApplication;

	}

}
