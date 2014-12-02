package com.me.coopapp;

import com.me.coopapp.dal.ISQLTransaction.TransactionType;
import com.me.coopapp.dal.transaction.User;


public class UserState {
	
	private static UserState instance;
	private User entity;
	public String imageName;
	
	private UserState() {

	}
	
	public static UserState getInstance() {
		if(instance == null) {
			instance = new UserState();
		}
		return instance;
	}
	
	public String getImageName() {
		return imageName;
	}
	
	public void setImageName(String _imageName) {
		imageName = _imageName;
	}
	
	//Set instance attributes
	public void addUser() {
		
		UserTask task = new UserTask();
		task.setTransaction(TransactionType.INSERT);
		
		GameLogic.getInstance().UserTasks.add(task);
	}
	
	public void setUser(String _name, String _email) {
		
		setName(_name);
		setEmail(_email);
	}
	
	public void setName(String _name) {
		entity.setName(_name);
	}
	
	public void setEmail(String _email) {
		entity.setEmail(_email);
	}
	
	public enum Task { INSERT }

}
