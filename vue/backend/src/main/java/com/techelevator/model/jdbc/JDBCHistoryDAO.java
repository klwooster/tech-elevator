package com.techelevator.model.jdbc;

import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.History;
import com.techelevator.model.IHistoryChangesDAO;
import com.techelevator.model.IHistoryDAO;

@Component
public class JDBCHistoryDAO implements IHistoryDAO {
	private final JdbcTemplate jdbcTemplate;
	private final IHistoryChangesDAO historyChangesDAO;

	public JDBCHistoryDAO(DataSource dataSource, IHistoryChangesDAO historyChangesDAO) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.historyChangesDAO = historyChangesDAO;
	}

	@Override
	public List<History> getHistoryByChangedId(int id) {
		List<History> history = new ArrayList<History>();
		String sqlGetHistoryByChangedId = "SELECT history_id, date_of_change, update_made_by_id, "
				+ "changes_made_to_id, status FROM history WHERE changes_made_to_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetHistoryByChangedId, id);

		while (results.next()) {
			History record = mapRowToHistory(results);
			history.add(record);
		}

		return history;
	}

	@Override
	public List<History> getAllHistory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int logHistoryRecord(History history) {
		String sqlSaveHistory = "INSERT INTO history (date_of_change, update_made_by_id, changes_made_to_id, status) "
				+ "VALUES (?, ?, ?, ?)";

		jdbcTemplate.update(sqlSaveHistory, history.getDateOfChange(), history.getUpdateMadeById(),
				history.getChangesMadeToId(), history.getStatus());

		return getCurrentHistoryId();
	}

	@Override
	public History getHistoryByHistoryId(int id) {
		String sqlGetHistoryByHistoryId = "SELECT * from history WHERE history_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetHistoryByHistoryId, id);

		return mapRowToHistory(results);
	}

	private History mapRowToHistory(SqlRowSet results) {
		History history = new History();
		Instant instant = results.getTimestamp("date_of_change").toInstant();
		history.setDateOfChange(instant.atZone(ZoneId.systemDefault()).toLocalDateTime());
		history.setHistoryId(results.getInt("history_id"));
		history.setUpdateMadeById(results.getInt("update_made_by_id"));
		history.setChangesMadeToId(results.getInt("changes_made_to_id"));
		history.setStatus(results.getString("status"));
		history.setUpdatesMade(historyChangesDAO.getUpdatesByHistoryId(history.getHistoryId()));

		return history;
	}

	private int getCurrentHistoryId() {
		String sqlSelectNextId = "SELECT CURRVAL('history_history_id_seq')";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		int id = 0;

		if (results.next()) {
			id = results.getInt(1);
		} else {
			throw new RuntimeException("Something strange happened, unable to select next history id from sequence");
		}

		return id;
	}

}
