package com.techelevator.model.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.model.Account;
import com.techelevator.model.Application;
import com.techelevator.model.IPersonDAO;
import com.techelevator.model.Person;

public class JDBCApplicationDAOIntegrationTest {

	/*
	 * Using this particular implementation of DataSource so that every database
	 * interaction is part of the same database session and hence the same database
	 * transaction
	 */
	private static SingleConnectionDataSource dataSource;
	private JDBCApplicationDAO dao;

	/*
	 * Before any tests are run, this method initializes the datasource for testing.
	 */
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/summercamp");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		/*
		 * The following line disables autocommit for connections returned by this
		 * DataSource. This allows us to rollback any changes after each test
		 */
		dataSource.setAutoCommit(false);
	}

	@Before
	public void setup() {
		// String sqlInsertEmployee= "INSERT INTO department (name) VALUES (Sales)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		JDBCPersonDAO personDAO = new JDBCPersonDAO(dataSource);
		JDBCNotesDAO notesDAO = new JDBCNotesDAO(dataSource);
		dao = new JDBCApplicationDAO(dataSource,personDAO,notesDAO);
	}

	/*
	 * After all tests have finished running, this method will close the DataSource
	 */
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	/*
	 * After each test, we rollback any changes that were made to the database so
	 * that everything is clean for the next test
	 */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	/*
	 * This method provides access to the DataSource for subclasses so that they can
	 * instantiate a DAO for testing
	 */
	protected DataSource getDataSource() {
		return dataSource;
	}
	
	@Test
	public void getApplicationByApplicationIdTest() throws SQLException {
		Application theApplication = new Application();

		theApplication = dao.getApplicationByApplicationId(1);

		assertNotNull(theApplication);
	}
	
	@Test
	public void getApplicationsByApplicantIdTest() throws SQLException {
		List<Application> results = dao.getApplicationsByApplicantId(1);
		int count = results.size();
		assertNotNull(results);
		assertEquals(count, results.size());
	}
	
	@Test
	public void getApplicationsByAccountIdTest() throws SQLException {
		List<Application> results = dao.getApplicationsByAccountId(1);
		int count = results.size();
		assertNotNull(results);
		assertEquals(count, results.size());
	}
	
	@Test
	public void getFullApplicationByApplicantIdTest() throws SQLException {
		Application theApplication = new Application();

		theApplication = dao.getFullApplicationByApplicantId(1);

		assertNotNull(theApplication);
	}
	
	@Test
	public void updateApplicationTest() throws SQLException {
		Application theApplication = new Application();
		Application dirtyApplicationCheck = new Application();
	    
	    theApplication.setApplicationId(1);
		theApplication.setApplicantId(1);
		theApplication.setAccountId(2);
		theApplication.setGuardianId(3);
		theApplication.setEmergencyContactId(4);
		theApplication.setDietaryPreference("dietary_");
		theApplication.setDietaryRestrictions("ds");
		theApplication.setMobilityIssues("mobili");
		theApplication.setMedicalConcerns("ns");
		theApplication.setMealPlan("meal_");
		theApplication.setProgram("program");
		theApplication.setDormAssignment("dort");
		theApplication.setTshirtSize("te");
		
		dao.updateApplication(theApplication);
		
		dirtyApplicationCheck = dao.getApplicationByApplicationId(1);
		
		assertEquals(dirtyApplicationCheck.getDormAssignment(), "dort");
	}
}
