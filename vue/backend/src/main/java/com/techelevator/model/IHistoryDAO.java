package com.techelevator.model;

import java.util.List;

public interface IHistoryDAO {
	public List<History> getHistoryByChangedId(int id);
	public History getHistoryByHistoryId(int id);
	public List<History> getAllHistory();
	public int logHistoryRecord(History history);
}
