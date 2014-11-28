package com.me.coopapp.dal.transaction;

import java.sql.Connection;
import java.sql.ResultSet;
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
	
	public void setName(String _name) {
		name = _name;
	}
	
	public void setEmail(String _email) {
		email = _email;
	}
	
	public void addUser(String _name, String _email) {
		name = _name;
		email = _email;
	}

	@Override
	public String insert() {
		
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
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String execute() {
		// TODO Auto-generated method stub
		return null;
	}

}
