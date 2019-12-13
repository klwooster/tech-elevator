package com.techelevator.model;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HistoryLogger {
	private final IHistoryDAO historyDao;
	private final IHistoryChangesDAO historyChangesDao;
	
	public HistoryLogger(IHistoryDAO historyDao, IHistoryChangesDAO historyChangesDao) {
		this.historyDao = historyDao;
		this.historyChangesDao = historyChangesDao;
	}
	
	public void logChanges(Application requestBody, Application oldValues, String status)  {
		History newHistory = createHistory(requestBody, status);
		int id = historyDao.logHistoryRecord(newHistory);
		newHistory.setHistoryId(id); 
		newHistory.setUpdatesMade(parseChanges(requestBody, oldValues, newHistory.getHistoryId()));
		historyChangesDao.logUpdates(newHistory.getUpdatesMade(), id);
		
	}
	
	private History createHistory(Application requestBody, String status) {
		History newHistory = new History();
		
		newHistory.setChangesMadeToId(requestBody.getApplicationId());
		newHistory.setDateOfChange(LocalDateTime.now());
		newHistory.setStatus(status);
		newHistory.setUpdateMadeById(1); //TODO remove hardcoded ID after session functionality is implemented
		
		return newHistory;
	}
	
	private List<Update> parseChanges(Application requestBody, Application oldValues, int historyId) {
		List<Update> updates = new ArrayList<Update>();
		
		Field[] appFields = oldValues.getClass().getDeclaredFields();
		
		for(Field field : appFields) {
			try {
				field.setAccessible(true);
				Object request = field.get(requestBody);
				Object oldValue = field.get(oldValues);
				
				if(request instanceof Integer) {
					if(((Integer) request).compareTo((Integer) oldValue) != 0) {
						updates.add(createNewUpdate(field, requestBody, oldValues, historyId));
					}
				} else if(request instanceof String) {
					if(!request.equals(oldValue)) {
						updates.add(createNewUpdate(field, requestBody, oldValues, historyId));
					}
				} else if(request instanceof Person) {
					Field[] personFields = oldValue.getClass().getDeclaredFields();
					
					for(Field subfield: personFields) {
						subfield.setAccessible(true);
						Object requestSubfield = subfield.get(request);
						Object oldValueSubfield = subfield.get(oldValue);
						
						if(requestSubfield instanceof String) {
							if(!requestSubfield.equals(oldValueSubfield)) {
								updates.add(createNewUpdate(subfield, request, oldValue, historyId));
							}
						} else {
							if(requestSubfield != oldValueSubfield) {
								updates.add(createNewUpdate(subfield, request, oldValue, historyId));
							}
						}
					}
				} else {
					if(request != oldValue) {
						updates.add(createNewUpdate(field, requestBody, oldValues, historyId));
					}
				}
				
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return updates;
	}
	
	private Update createNewUpdate(Field field, Object requestBody, Object oldValues, int id) {
		Update newChange = new Update();
		try{
			newChange.setHistoryId(id);
			newChange.setDataElementChanged(field.getName());
			newChange.setOldValue(field.get(oldValues).toString());
			newChange.setNewValue(field.get(requestBody).toString());
		} catch(Exception e) {
			
		}
		
		return newChange;
	}
}
