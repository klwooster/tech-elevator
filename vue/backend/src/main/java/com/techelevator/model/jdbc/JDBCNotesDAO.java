package com.techelevator.model.jdbc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.bouncycastle.util.encoders.Base64;
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
	
	@Override
	public void updateNotes(Notes inputNotes) {
		
		 int note_id = inputNotes.getNoteId();
		 String note_body = inputNotes.getNoteBody();
		 String create_date = inputNotes.getCreateDate();
		 int application_id = inputNotes.getApplicationId();
	     
		 String sqlUpdateNotes = "UPDATE notes SET note_body = ?, create_date = ?, application_id = ? WHERE note_id = ?";
	     jdbcTemplate.update(sqlUpdateNotes, note_body, create_date, application_id,note_id);
	}

	@Override
	public void createNewNotes(Notes inputNotes) {
		 
		 String note_body = inputNotes.getNoteBody();
		 LocalDate create_date = LocalDate.now();
		 int application_id = inputNotes.getApplicationId();
	     
		 String sqlNewNotes = "INSERT INTO notes (note_body, create_date, application_id) VALUES (?,?,?)";
	     jdbcTemplate.update(sqlNewNotes, note_body, create_date, application_id);
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
