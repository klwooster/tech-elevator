package com.techelevator.model;

import java.time.LocalDateTime;
import java.util.List;

public class History {
	private LocalDateTime dateOfChange;
	private int updateMadeById;
	private int changesMadeToId;
	private int historyId;
	private String status;
	private List<Update> updatesMade;
	
	public LocalDateTime getDateOfChange() {
		return dateOfChange;
	}
	public void setDateOfChange(LocalDateTime dateOfChange) {
		this.dateOfChange = dateOfChange;
	}
	public int getUpdateMadeById() {
		return updateMadeById;
	}
	public void setUpdateMadeById(int updateMadeById) {
		this.updateMadeById = updateMadeById;
	}
	public int getChangesMadeToId() {
		return changesMadeToId;
	}
	public void setChangesMadeToId(int changesMadeToId) {
		this.changesMadeToId = changesMadeToId;
	}

	public int getHistoryId() {
		return historyId;
	}
	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Update> getUpdatesMade() {
		return updatesMade;
	}
	public void setUpdatesMade(List<Update> updatesMade) {
		this.updatesMade = updatesMade;
	}
}
