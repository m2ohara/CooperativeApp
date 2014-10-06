package com.me.coopapp;

import org.sqlite.SQLiteConnection;

public class Task {
	
	private IEntity entity;
	public String imageName;
	private SQLiteConnection conn;
	
	public Task(IEntity _entity) {
		entity = _entity;
	}
	
	public void startTransaction() {
		conn = SQLConnection.getConnection();
	}
	
	public void executeTransaction(String transactionType) {
		if(transactionType == "Insert") {
			
		}
		else if(transactionType == "Update") {
			
		}
		else if(transactionType == "Delete") {
			
		}
		else {
			//Throw exception
		}		
	}
	
	public void commitTransaction() {
		
	}
	
	public String getImageName() {
		return imageName;
	}
	
	public void setImageName(String _imageName) {
		imageName = _imageName;
	}
	

}
