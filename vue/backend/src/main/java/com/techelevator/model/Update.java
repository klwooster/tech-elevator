package com.techelevator.model;

public class Update {
	private int historyId;
	private String oldValue;
	private String newValue;
	private String dataElementChanged;
	
	public Update() {
		
	}

	public int getHistoryId() {
		return historyId;
	}

	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public String getDataElementChanged() {
		return dataElementChanged;
	}

	public void setDataElementChanged(String dataElementChanged) {
		this.dataElementChanged = dataElementChanged;
	}
}