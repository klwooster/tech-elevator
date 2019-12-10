package com.techelevator.model.jdbc;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.model.IWorkshopsDAO;
import com.techelevator.model.Workshops;

public class JDBCWorkshopsDAO implements IWorkshopsDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCWorkshopsDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Workshops getWorkshopsByApplicationId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
