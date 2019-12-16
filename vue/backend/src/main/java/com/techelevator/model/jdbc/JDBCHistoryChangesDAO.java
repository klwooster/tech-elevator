package com.techelevator.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.IHistoryChangesDAO;
import com.techelevator.model.Update;

@Component
public class JDBCHistoryChangesDAO implements IHistoryChangesDAO {
	private final JdbcTemplate jdbcTemplate;
	
	public JDBCHistoryChangesDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Update> getUpdatesByHistoryId(int id) {
		List<Update> updates = new ArrayList<Update>();
		String sqlGetUpdatesByHistoryId = "SELECT * FROM history_changes WHERE history_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetUpdatesByHistoryId, id);
		
		while(results.next()) {
			updates.add(mapRowToUpdate(results));
		}
		
		return updates;
	}

	@Override
	public void logUpdates(List<Update> updates, int id) {
		String sqlLogUpdates = "INSERT INTO history_changes (history_id, old_value, new_value, data_element_changed) "
							 + "VALUES (?, ?, ?, ?)";
		if(!(updates == null || updates.isEmpty())) {
			for(Update update : updates) {
				jdbcTemplate.update(sqlLogUpdates, id, update.getOldValue(), update.getNewValue(), update.getDataElementChanged());
			}
		}
	}

	private Update mapRowToUpdate(SqlRowSet results) {
		Update update = new Update();
		
		update.setDataElementChanged(results.getString("data_element_changed"));
		update.setHistoryId(results.getInt("history_id"));
		update.setNewValue(results.getString("new_value"));
		update.setOldValue(results.getString("old_value"));
		
		return update;
	}
	
}
