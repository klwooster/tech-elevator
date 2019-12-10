package com.techelevator.model;

public interface IWorkshopsDAO {

	//Workshop by Application Id
	public Workshops getWorkshopsByApplicationId(int id);
}
