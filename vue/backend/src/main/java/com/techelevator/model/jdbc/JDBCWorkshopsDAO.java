package com.techelevator.model.jdbc;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Application;
import com.techelevator.model.IWorkshopsDAO;
import com.techelevator.model.Workshops;

public class JDBCWorkshopsDAO implements IWorkshopsDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCWorkshopsDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Workshops getWorkshopsByApplicationId(int id) {
		Workshops theWorkshops = null;
		String sqlFindWordshopsByApplicationId = "SELECT application_id,workshop,rank FROM workshops WHERE application_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindWordshopsByApplicationId, id);
		if (results.next()) {
			theWorkshops = mapRowToApplication(results);
		}
		return theWorkshops;
	}

	private Workshops mapRowToApplication(SqlRowSet results) {
		Workshops theWorkshops;
		theWorkshops = new Workshops();
		theWorkshops.setApplicationId(results.getInt("application_id"));
		theWorkshops.setWorkshop(results.getString("workshop"));
		theWorkshops.setRank(results.getInt("rank"));
		
		return theWorkshops;

	}
}
