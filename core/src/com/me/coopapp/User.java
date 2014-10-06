package com.me.coopapp;

public class User implements IEntity {
	
	private static User userInstance;
	
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
	public void Update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object Get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Insert() {
		String query = "INSERT VALUES ('User XXX', 'Setup') INTO USER";
	}

	@Override
	public void Execute() {
		// TODO Auto-generated method stub
		
	}
	
	

}
