package com.techelevator.model.jdbc;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.model.IPersonDAO;
import com.techelevator.model.Person;

public class JDBCPersonDAO implements IPersonDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCPersonDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
