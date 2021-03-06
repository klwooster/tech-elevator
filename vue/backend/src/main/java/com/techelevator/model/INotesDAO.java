package com.techelevator.model;

import java.util.List;

public interface INotesDAO {
	
	//Note by Note id
	public Notes getNotesByNoteId(int id);
	
	//List of Notes for Application Id
	public List<Notes> getNotesByApplicationId(int id);
	
	//Update Notes for Note Id
	public void updateNotes(Notes notes);
	
	//Create New Note
	public void createNewNotes(Notes notes);
}
