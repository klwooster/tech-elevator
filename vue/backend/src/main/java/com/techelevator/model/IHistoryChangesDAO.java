package com.techelevator.model;

import java.util.List;

public interface IHistoryChangesDAO {
	public List<Update> getUpdatesByHistoryId(int id);
	public void logUpdates(List<Update> updates, int id);
}
