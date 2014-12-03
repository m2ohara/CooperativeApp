package com.me.coopapp;

import com.me.coopapp.dal.ISQLTransaction.TransactionType;
import com.me.coopapp.entity.User;


public class UserState {
	
	private static UserState instance;
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
		User.getInstance().setName(_name);
	}
	
	public void setEmail(String _email) {
		User.getInstance().setEmail(_email);
	}
	
	public enum Task { INSERT }

}
