package com.techelevator.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Account;
import com.techelevator.model.Application;
import com.techelevator.model.IApplicationDAO;
import com.techelevator.model.INotesDAO;
import com.techelevator.model.IPersonDAO;
import com.techelevator.model.Notes;
import com.techelevator.model.Person;

@Component
public class JDBCApplicationDAO implements IApplicationDAO {

	private final JdbcTemplate jdbcTemplate;
	private final IPersonDAO personDAO;
	private final INotesDAO notesDAO;

	public JDBCApplicationDAO(DataSource dataSource, IPersonDAO personDAO, INotesDAO notesDAO) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.personDAO = personDAO;
		this.notesDAO = notesDAO;
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
	
	@Override
	public Application getFullApplicationByApplicantId(int id) {
		
		Application theApplication = null;
		String sqlFindApplicationByApplicationId = "SELECT application_id, applicant_id ,account_id,guardian_id,emergency_contact_id,dietary_preference ,dietary_restrictions,mobility_issues,medical_concerns,meal_plan,program,dorm_assignment,tshirt_size FROM application WHERE application_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindApplicationByApplicationId, id);
		if (results.next()) {
			theApplication = mapRowToApplication(results);
		}
		
		//Get the Person Data for the Applicant
		theApplication.setApplicant(personDAO.getPersonByPersonId(id));
		
		//Get the Person Data for the Guardian
		theApplication.setGuardian(personDAO.getPersonByPersonId(theApplication.getGuardianId()));
		
		//Get the Person Data for the Emergency Contact
		theApplication.setEmergencyContact(personDAO.getPersonByPersonId(theApplication.getEmergencyContactId()));
		
		//Get the Notes for the Applicant Id
		theApplication.setNotes(notesDAO.getNotesByApplicationId(id));
		
		return theApplication;
	}
	
	@Override
	public void updateApplication(Application inputApplication) {
		
		 int application_id = inputApplication.getApplicationId();
		 int applicant_id = inputApplication.getApplicantId();
		 int account_id = inputApplication.getAccountId();
		 int guardian_id = inputApplication.getGuardianId();
		 int emergency_contact_id = inputApplication.getEmergencyContactId();
		 String dietary_preference = inputApplication.getDietaryPreference();
		 String dietary_restrictions = inputApplication.getDietaryRestrictions();
		 String mobility_issues = inputApplication.getMobilityIssues();
		 String medical_concerns = inputApplication.getMedicalConcerns();
		 String meal_plan = inputApplication.getMealPlan();
		 String program = inputApplication.getProgram();
		 String dorm_assignment = inputApplication.getDormAssignment();
		 String tshirt_size = inputApplication.getTshirtSize();
	     
		 String sqlUpdateApplicationBApplicationId = "UPDATE application SET applicant_id = ?, account_id = ?, guardian_id = ?, emergency_contact_id = ?, dietary_preference = ?, dietary_restrictions = ? , mobility_issues = ?,  medical_concerns = ?, meal_plan = ?, program = ?, dorm_assignment = ?, tshirt_size = ? WHERE application_id = ?";
	     jdbcTemplate.update(sqlUpdateApplicationBApplicationId, applicant_id, account_id, guardian_id, emergency_contact_id, dietary_preference, dietary_restrictions, mobility_issues, medical_concerns, meal_plan, program, dorm_assignment, tshirt_size, application_id);
		
	}
	
	@Override
	public void updateFullApplication(Application inputApplication) {
		
		 int application_id = inputApplication.getApplicationId();
		 int applicant_id = inputApplication.getApplicantId();
		 int account_id = inputApplication.getAccountId();
		 int guardian_id = inputApplication.getGuardianId();
		 int emergency_contact_id = inputApplication.getEmergencyContactId();
		 String dietary_preference = inputApplication.getDietaryPreference();
		 String dietary_restrictions = inputApplication.getDietaryRestrictions();
		 String mobility_issues = inputApplication.getMobilityIssues();
		 String medical_concerns = inputApplication.getMedicalConcerns();
		 String meal_plan = inputApplication.getMealPlan();
		 String program = inputApplication.getProgram();
		 String dorm_assignment = inputApplication.getDormAssignment();
		 String tshirt_size = inputApplication.getTshirtSize();
	     
		 String sqlUpdateApplicationBApplicationId = "UPDATE application SET applicant_id = ?, account_id = ?, guardian_id = ?, emergency_contact_id = ?, dietary_preference = ?, dietary_restrictions = ? , mobility_issues = ?,  medical_concerns = ?, meal_plan = ?, program = ?, dorm_assignment = ?, tshirt_size = ? WHERE application_id = ?";
	     jdbcTemplate.update(sqlUpdateApplicationBApplicationId, applicant_id, account_id, guardian_id, emergency_contact_id, dietary_preference, dietary_restrictions, mobility_issues, medical_concerns, meal_plan, program, dorm_assignment, tshirt_size, application_id);
		
	     int person_id = inputApplication.getApplicant().getPersonId();
		 String first_name = inputApplication.getApplicant().getFirstName();
		 String last_name = inputApplication.getApplicant().getLastName();
		 String preferred_name = inputApplication.getApplicant().getPreferredName();
		 String date_of_birth = inputApplication.getApplicant().getDateOfBirth();
		 String email = inputApplication.getApplicant().getEmail();
		 String phone = inputApplication.getApplicant().getPhone();
	     
		 String sqlUpdateApplicant = "UPDATE person SET first_name = ?, last_name = ?, preferred_name = ?, date_of_birth = ?, email = ?, phone = ? WHERE person_id = ?";
	     jdbcTemplate.update(sqlUpdateApplicant, first_name, last_name, preferred_name, date_of_birth, email, phone, person_id);
	     
	     int guardian_person_id = inputApplication.getGuardian().getPersonId();
		 String guardian_first_name = inputApplication.getGuardian().getFirstName();
		 String guardian_last_name = inputApplication.getGuardian().getLastName();
		 String guardian_preferred_name = inputApplication.getGuardian().getPreferredName();
		 String guardian_date_of_birth = inputApplication.getGuardian().getDateOfBirth();
		 String guardian_email = inputApplication.getGuardian().getEmail();
		 String guardian_phone = inputApplication.getGuardian().getPhone();
	     
		 String sqlUpdateGuardian = "UPDATE person SET first_name = ?, last_name = ?, preferred_name = ?, date_of_birth = ?, email = ?, phone = ? WHERE person_id = ?";
	     jdbcTemplate.update(sqlUpdateGuardian, guardian_first_name, guardian_last_name, guardian_preferred_name, guardian_date_of_birth, guardian_email, guardian_phone, guardian_person_id);
	     
	     int emergencycontact_person_id = inputApplication.getEmergencyContact().getPersonId();
		 String emergencycontact_first_name = inputApplication.getEmergencyContact().getFirstName();
		 String emergencycontact_last_name = inputApplication.getEmergencyContact().getLastName();
		 String emergencycontact_preferred_name = inputApplication.getEmergencyContact().getPreferredName();
		 String emergencycontact_date_of_birth = inputApplication.getEmergencyContact().getDateOfBirth();
		 String emergencycontact_email = inputApplication.getEmergencyContact().getEmail();
		 String emergencycontact_phone = inputApplication.getEmergencyContact().getPhone();
	     
		 String sqlUpdatePerson = "UPDATE person SET first_name = ?, last_name = ?, preferred_name = ?, date_of_birth = ?, email = ?, phone = ? WHERE person_id = ?";
	     jdbcTemplate.update(sqlUpdatePerson, emergencycontact_first_name, emergencycontact_last_name, emergencycontact_preferred_name, emergencycontact_date_of_birth, emergencycontact_email, emergencycontact_phone, emergencycontact_person_id);
	     
	     List<Notes> inputNotes = inputApplication.getNotes();
	     
	     for (Notes note: inputNotes) {
		     int note_note_id = note.getNoteId();
			 String note_note_body = note.getNoteBody();
			 String note_create_date = note.getCreateDate();
			 int note_application_id = note.getApplicationId();
		     
			 String sqlUpdateNotes = "UPDATE notes SET note_body = ?, create_date = ?, application_id = ? WHERE note_id = ?";
		     jdbcTemplate.update(sqlUpdateNotes, note_note_body, note_create_date, note_application_id, note_note_id);
	     } 
	}
	
	@Override
	public void createNewApplication(Application inputApplication) {
		int application_id = inputApplication.getApplicationId();
		 int applicant_id = inputApplication.getApplicantId();
		 int account_id = inputApplication.getAccountId();
		 int guardian_id = inputApplication.getGuardianId();
		 int emergency_contact_id = inputApplication.getEmergencyContactId();
		 String dietary_preference = inputApplication.getDietaryPreference();
		 String dietary_restrictions = inputApplication.getDietaryRestrictions();
		 String mobility_issues = inputApplication.getMobilityIssues();
		 String medical_concerns = inputApplication.getMedicalConcerns();
		 String meal_plan = inputApplication.getMealPlan();
		 String program = inputApplication.getProgram();
		 String dorm_assignment = inputApplication.getDormAssignment();
		 String tshirt_size = inputApplication.getTshirtSize();
	     
		 String sqlUpdateApplicationBApplicationId = "INSERT INTO application  (applicant_id, account_id, guardian_id, emergency_contact_id, dietary_preference, dietary_restrictions, mobility_issues,  medical_concerns, meal_plan, program, dorm_assignment, tshirt_size) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
	     jdbcTemplate.update(sqlUpdateApplicationBApplicationId, applicant_id, account_id, guardian_id, emergency_contact_id, dietary_preference, dietary_restrictions, mobility_issues, medical_concerns, meal_plan, program, dorm_assignment, tshirt_size, application_id);
		
	     int person_id = inputApplication.getApplicant().getPersonId();
		 String first_name = inputApplication.getApplicant().getFirstName();
		 String last_name = inputApplication.getApplicant().getLastName();
		 String preferred_name = inputApplication.getApplicant().getPreferredName();
		 String date_of_birth = inputApplication.getApplicant().getDateOfBirth();
		 String email = inputApplication.getApplicant().getEmail();
		 String phone = inputApplication.getApplicant().getPhone();
	     
		 String sqlUpdateApplicant = "UPDATE person SET first_name = ?, last_name = ?, preferred_name = ?, date_of_birth = ?, email = ?, phone = ? WHERE person_id = ?";
	     jdbcTemplate.update(sqlUpdateApplicant, first_name, last_name, preferred_name, date_of_birth, email, phone, person_id);
	     
	     int guardian_person_id = inputApplication.getGuardian().getPersonId();
		 String guardian_first_name = inputApplication.getGuardian().getFirstName();
		 String guardian_last_name = inputApplication.getGuardian().getLastName();
		 String guardian_preferred_name = inputApplication.getGuardian().getPreferredName();
		 String guardian_date_of_birth = inputApplication.getGuardian().getDateOfBirth();
		 String guardian_email = inputApplication.getGuardian().getEmail();
		 String guardian_phone = inputApplication.getGuardian().getPhone();
	     
		 String sqlUpdateGuardian = "UPDATE person SET first_name = ?, last_name = ?, preferred_name = ?, date_of_birth = ?, email = ?, phone = ? WHERE person_id = ?";
	     jdbcTemplate.update(sqlUpdateGuardian, guardian_first_name, guardian_last_name, guardian_preferred_name, guardian_date_of_birth, guardian_email, guardian_phone, guardian_person_id);
	     
	     int emergencycontact_person_id = inputApplication.getEmergencyContact().getPersonId();
		 String emergencycontact_first_name = inputApplication.getEmergencyContact().getFirstName();
		 String emergencycontact_last_name = inputApplication.getEmergencyContact().getLastName();
		 String emergencycontact_preferred_name = inputApplication.getEmergencyContact().getPreferredName();
		 String emergencycontact_date_of_birth = inputApplication.getEmergencyContact().getDateOfBirth();
		 String emergencycontact_email = inputApplication.getEmergencyContact().getEmail();
		 String emergencycontact_phone = inputApplication.getEmergencyContact().getPhone();
	     
		 String sqlUpdatePerson = "UPDATE person SET first_name = ?, last_name = ?, preferred_name = ?, date_of_birth = ?, email = ?, phone = ? WHERE person_id = ?";
	     jdbcTemplate.update(sqlUpdatePerson, emergencycontact_first_name, emergencycontact_last_name, emergencycontact_preferred_name, emergencycontact_date_of_birth, emergencycontact_email, emergencycontact_phone, emergencycontact_person_id);
	     
	     List<Notes> inputNotes = inputApplication.getNotes();
	     
	     for (Notes note: inputNotes) {
		     int note_note_id = note.getNoteId();
			 String note_note_body = note.getNoteBody();
			 String note_create_date = note.getCreateDate();
			 int note_application_id = note.getApplicationId();
		     
			 String sqlUpdateNotes = "UPDATE notes SET note_body = ?, create_date = ?, application_id = ? WHERE note_id = ?";
		     jdbcTemplate.update(sqlUpdateNotes, note_note_body, note_create_date, note_application_id, note_note_id);
	     } 
		
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
