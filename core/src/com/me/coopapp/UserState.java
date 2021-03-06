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
	
	//Create tasks
	public void setAddUserTask() {
		
		UserTask task = new UserTask();
		task.setTransaction(TransactionType.INSERT);
		
		GameLogic.getInstance().userTasks.put(task.hashCode(), task);
	}
	
	public void setUpdateUserTask() {
		UserTask task = new UserTask();
		task.setTransaction(TransactionType.UPDATE);
		GameLogic.getInstance().userTasks.put(task.hashCode(), task);
	}
	
	//Set instance properties
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
	
	public void setAlias(String alias) {
		User.getInstance().setAlias(alias);
	}
	
	public enum Task { INSERT }

}
