package com.techelevator.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Account;
import com.techelevator.model.IAccountDAO;
import com.techelevator.model.Person;

public class JDBCAccountDAO implements IAccountDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCAccountDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Account> getAllPersonsForAccountId(int id) {
		List<Account> personIds = new ArrayList<>();

		String sqlFindPersons = "SELECT account_id, person_id FROM account WHERE account_id = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindPersons, id);

		while (results.next()) {
			Account thePersonId = mapRowToAccount(results);
			personIds.add(thePersonId);
		}

		return personIds;
	}
	
	private Account mapRowToAccount(SqlRowSet results) {
		Account theAccount;
		theAccount = new Account();
		theAccount.setAccountId(results.getInt("account_id"));
		theAccount.setPersonId(results.getInt("person_id"));

		return theAccount;

	}

}
