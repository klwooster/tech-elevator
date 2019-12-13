package com.techelevator.model;

public class ChangeStatus {
	private String status;
	private int id;
	
	public ChangeStatus(String status, int id) {
		this.status = status;
		this.id = id;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
