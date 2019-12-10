package com.techelevator.model.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.model.INotesDAO;
import com.techelevator.model.Notes;

public class JDBCNotesDAO implements INotesDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCNotesDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Notes getNotesByNoteId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notes> getNotesByApplicationId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
