package com.techelevator.model.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.model.Application;
import com.techelevator.model.IApplicationDAO;

public class JDBCApplicationDAO implements IApplicationDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCApplicationDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Application getApplicationByApplicationId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Application> getApplicationsByApplicantId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Application> getApplicationsByAccountId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
