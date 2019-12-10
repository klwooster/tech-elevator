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
import com.techelevator.model.Person;

public class JDBCPersonDAOIntegrationTest {

	/*
	 * Using this particular implementation of DataSource so that every database
	 * interaction is part of the same database session and hence the same database
	 * transaction
	 */
	private static SingleConnectionDataSource dataSource;
	private JDBCPersonDAO dao;

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
		dao = new JDBCPersonDAO(dataSource);
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
	public void getPersonByPersonIdTest() throws SQLException {
		Person thePerson = new Person();

		thePerson = dao.getPersonByPersonId(1);

		assertNotNull(thePerson);
	}
	
	@Test
	public void getAllPersonsTest() throws SQLException {
		List<Person> results = dao.getAllPersons();
		int count = results.size();
		assertNotNull(results);
		assertEquals(count, results.size());
	}
	
	@Test
	public void getAllPersonsAndAccountIdTest() throws SQLException {
		List<Person> results = dao.getAllPersons();
		int count = results.size();
		assertNotNull(results);
		assertEquals(count, results.size());
	}
	
}
