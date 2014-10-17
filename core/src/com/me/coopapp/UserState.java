package com.me.coopapp;

import java.sql.Statement;

import org.sqlite.SQLiteConnection;

public class UserState implements ITask {
	
	private IEntity entity;
	public String imageName;
	private SQLiteConnection conn;
	private Statement statement;
	
	public UserState(IEntity _entity) {
		entity = _entity;
	}
	
	public void perform(boolean isGdxThread) {
		startTransaction();
		executeTransaction(entity.GetAction());
	}
	
	public void startTransaction() {
		
		try {
			conn = SQLConnection.getConnection();
			statement = conn.createStatement();
		}
		catch(Exception e) {
			
		}
	}
	
	public void executeTransaction(String transactionType) {
		try {
			if(transactionType == "Insert") {
				statement.executeUpdate((entity.Insert()));
			}
			else if(transactionType == "Update") {
				statement.executeUpdate((entity.Update()));
			}
			else if(transactionType == "Delete") {
				statement.executeUpdate((entity.Delete()));
			}
			else {
				//Log error
			}		
		}
		catch(Exception e) {
			
		}
		finally {
			
			if(conn != null) {
				try {
					statement.close();
					conn.close();
				}
				catch(Exception e) {
					
				}
			}
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

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isTaskComplete() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
