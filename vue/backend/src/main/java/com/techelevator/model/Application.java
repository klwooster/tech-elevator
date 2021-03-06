package com.techelevator.model;

import java.util.List;

public class Application {
	private int applicationId;
	private int applicantId;
	private int accountId;
	private int guardianId;
	private int emergencyContactId;
	private String dietaryPreference;
	private String dietaryRestrictions;
	private String mobilityIssues;
	private String medicalConcerns;
	private String mealPlan;
	private String program;
	private String dormAssignment;
	private String tshirtSize;
	private Camp campProgram;
	private Person applicant;
	private Person guardian;
	private Person emergencyContact;
	
	private List<Notes> notes;
	
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public int getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getGuardianId() {
		return guardianId;
	}
	public void setGuardianId(int guardianId) {
		this.guardianId = guardianId;
	}
	public int getEmergencyContactId() {
		return emergencyContactId;
	}
	public void setEmergencyContactId(int emergencyContactId) {
		this.emergencyContactId = emergencyContactId;
	}
	public String getDietaryPreference() {
		return dietaryPreference;
	}
	public void setDietaryPreference(String dietaryPreference) {
		this.dietaryPreference = dietaryPreference;
	}
	public String getDietaryRestrictions() {
		return dietaryRestrictions;
	}
	public void setDietaryRestrictions(String dietaryRestrictions) {
		this.dietaryRestrictions = dietaryRestrictions;
	}
	public String getMobilityIssues() {
		return mobilityIssues;
	}
	public void setMobilityIssues(String mobilityIssues) {
		this.mobilityIssues = mobilityIssues;
	}
	public String getMedicalConcerns() {
		return medicalConcerns;
	}
	public void setMedicalConcerns(String medicalConcerns) {
		this.medicalConcerns = medicalConcerns;
	}
	public String getMealPlan() {
		return mealPlan;
	}
	public void setMealPlan(String mealPlan) {
		this.mealPlan = mealPlan;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public String getDormAssignment() {
		return dormAssignment;
	}
	public void setDormAssignment(String dormAssignment) {
		this.dormAssignment = dormAssignment;
	}
	public String getTshirtSize() {
		return tshirtSize;
	}
	public void setTshirtSize(String tshirtSize) {
		this.tshirtSize = tshirtSize;
	}
	public Person getApplicant() {
		return applicant;
	}
	public void setApplicant(Person applicant) {
		this.applicant = applicant;
	}
	public Person getGuardian() {
		return guardian;
	}
	public void setGuardian(Person guardian) {
		this.guardian = guardian;
	}
	public Person getEmergencyContact() {
		return emergencyContact;
	}
	public void setEmergencyContact(Person emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	public List<Notes> getNotes() {
		return notes;
	}
	public void setNotes(List<Notes> notes) {
		this.notes = notes;
	}
	public Camp getCampProgram() {
		return campProgram;
	}
	public void setCampProgram(Camp campProgram) {
		this.campProgram = campProgram;
	}
}
