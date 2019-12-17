package com.techelevator.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Camp {
	private int campId;
	private String name;
	private String description;
	private String location;
	private LocalDate startDate;
	private LocalDate endDate;
	private int minAge;
	private int maxAge;
	private int totalCapacity;
	private int remainingSpaces;
	private List<Person> attendees;
	private Map<String, Integer> ageDistribution;
	private String image;
	private String dateRange;
	
	public int getCampId() {
		return campId;
	}
	public void setCampId(int campId) {
		this.campId = campId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public int getMinAge() {
		return minAge;
	}
	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
	public int getTotalCapacity() {
		return totalCapacity;
	}
	public void setTotalCapacity(int totalCapacity) {
		this.totalCapacity = totalCapacity;
	}
	public int getRemainingSpaces() {
		return remainingSpaces;
	}
	public void setRemainingSpaces(int remainingSpaces) {
		this.remainingSpaces = remainingSpaces;
	}
	public List<Person> getAttendees() {
		return attendees;
	}
	public void setAttendees(List<Person> attendees) {
		this.attendees = attendees;
	}
	public Map<String, Integer> getAgeDistribution() {
		return ageDistribution;
	}
	public void setAgeDistribution(Map<String, Integer> ageDistribution) {
		this.ageDistribution = ageDistribution;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDateRange() {
		return dateRange;
	}
	public void setDateRange(String dateRange) {
		this.dateRange = dateRange;
	}
}
