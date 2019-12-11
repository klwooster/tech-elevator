package com.techelevator.model.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.time.LocalDate;
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
import com.techelevator.model.Notes;

public class JDBCNotesDAOIntegrationTest {

	/*
	 * Using this particular implementation of DataSource so that every database
	 * interaction is part of the same database session and hence the same database
	 * transaction
	 */
	private static SingleConnectionDataSource dataSource;
	private JDBCNotesDAO dao;

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
		dao = new JDBCNotesDAO(dataSource);
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
	public void getNotesByNoteIdTest() throws SQLException {
		Notes theNotes = new Notes();

		theNotes = dao.getNotesByNoteId(1);

		assertNotNull(theNotes);
	}
	
	@Test
	public void getNotesByApplicationIdTest() throws SQLException {
		List<Notes> results = dao.getNotesByApplicationId(1);
		int count = results.size();
		assertNotNull(results);
		assertEquals(count, results.size());
	}
	
	@Test
	public void updateNotesTest() throws SQLException {
		Notes theNotes = new Notes();
		Notes dirtyNotesCheck = new Notes();

		theNotes.setNoteId(1);
		theNotes.setNoteBody("Testing the Update");
		theNotes.setCreateDate(null);
		theNotes.setApplicationId(1);
		
		dao.updateNotes(theNotes);
		
		dirtyNotesCheck = dao.getNotesByNoteId(1);
		
		assertEquals(dirtyNotesCheck.getNoteBody(), "Testing the Update");
	}
	
}
