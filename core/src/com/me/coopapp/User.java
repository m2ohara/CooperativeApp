package com.me.coopapp;

public class User implements IEntity {
	
	private static User userInstance = new User();
	
	private User() {
		//Get persisted data
	}
	
	//Retrieve single instance of class
	public static User getUser() {
		return userInstance;
	
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object Get() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
