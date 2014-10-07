package com.me.coopapp;

public class User implements IEntity {
	
	private static User userInstance;
	public String action = "";
	
	private User() {
		//Get persisted data
	}
	
	//Retrieve single instance of class
	public static User getUser() {		
		if(userInstance == null) {
			userInstance = new User();
		}
		return userInstance;
	
	}

	@Override
	public String Update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Insert() {
		String query = "INSERT VALUES ('User XXX', 'Setup') INTO USER";
		
		return query;
	}

	@Override
	public String Execute() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String GetAction() {
		// TODO Auto-generated method stub
		return action;
	}
	
	

}
