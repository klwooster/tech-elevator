package com.techelevator.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Application;
import com.techelevator.model.INotesDAO;
import com.techelevator.model.Notes;

@Component
public class JDBCNotesDAO implements INotesDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCNotesDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Notes getNotesByNoteId(int id) {
		Notes theNotes = null;
		String sqlFindNotesByNoteId = "SELECT note_id, note_body, create_date, application_id FROM notes WHERE note_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindNotesByNoteId, id);
		if (results.next()) {
			theNotes = mapRowToApplication(results);
		}
		return theNotes;
	}

	@Override
	public List<Notes> getNotesByApplicationId(int id) {
		List<Notes> notes = new ArrayList<>();

		String sqlNotesByApplicationId = "SELECT note_id, note_body, create_date, application_id FROM notes WHERE application_id = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlNotesByApplicationId, id);

		while (results.next()) {
			Notes theNotes = mapRowToApplication(results);
			notes.add(theNotes);
		}

		return notes;
	}

	private Notes mapRowToApplication(SqlRowSet results) {
		Notes theNotes;
		theNotes = new Notes();
		theNotes.setNoteId(results.getInt("note_id"));
		theNotes.setNoteBody(results.getString("note_body"));
		theNotes.setCreateDate(results.getString("create_date"));
		theNotes.setApplicationId(results.getInt("application_id"));
		
		return theNotes;

	}
	
}
