package com.me.coopapp.dal.transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.me.coopapp.IEntity;
import com.me.coopapp.dal.SQLConnection;

public class User implements IEntity {
	
	private Connection connection;
	private String name;
	private String email;
	
	public User() {
		connection = SQLConnection.get();

	}
	
	public boolean Add(String _name, String _email) {
		
		name = _name;
		email = _email;
		
		if(Insert() == "success") {
			return true;
		}
		
		return false;
		
	}

	@Override
	public String Insert() {
		
		Statement addUserStatement = null;
		
		//Create SQL
		String SQL = "INSERT values ("+ name+", "+email+") INTO USER";
		
		//Initialise as false
		int result = -1;
		
		try {
			
			//Create user
			addUserStatement = connection.createStatement();
			result = addUserStatement.executeUpdate(SQL);
		}
		catch(SQLException ex) {
		//TO DO: Log error
			System.out.println("Error inserting user: "+ex);
		}
		finally {
			try {
				addUserStatement.close();
				connection.close();
			}
			catch(SQLException e) {
				//TO DO: Log error
				System.out.println("Error closing statement: "+e);
			}
		}
		
		return result == -1 ? "error" : "success";
	}

	@Override
	public String Update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Delete() {
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
	public String Execute() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String GetAction() {
		// TODO Auto-generated method stub
		return null;
	}

}
