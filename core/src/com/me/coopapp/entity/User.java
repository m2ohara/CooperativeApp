package com.me.coopapp.entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.me.coopapp.dal.SQLConnection;

public class User implements IEntity {
	
	private static User instance;
	private static Connection connection;
	private String id;
	private String name;
	private String email;
	private String alias;
	
	private User() {
		connection = SQLConnection.get();
		id = App.get().getId();
	}
	
	public static User getInstance() {
		if(instance == null) {
			instance = new User();
		}
		try {
			if(connection == null || connection.isClosed()) {
				connection = SQLConnection.get();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return instance;
	}

	@Override
	public int insert() {
		
		Statement addUserStatement = null;
		
		//Create SQL
		if(name == null || email == null) {
			return -1;
		}
		
		String SQL = "INSERT INTO USER (NAME, ACCOUNT_IDENTIFIER, STATE, ALIAS) values ('"+name+"', '"+email+"', 1, null)";
		
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
		
		return result;
	}

	@Override
	public int update() {
		
		Statement updateUserStatement = null;
		
		//Create SQL
		if(alias == null || id == null) {
			return -1;
		}
		
		String SQL = "UPDATE USER  SET ALIAS = '"+alias+"' WHERE rowid = "+id+"";
		
		//Initialise as false
		int result = -1;
		
		try {
			
			//Create user
			updateUserStatement = connection.createStatement();
			result = updateUserStatement.executeUpdate(SQL);
		}
		catch(SQLException ex) {
			//TO DO: Log error
			System.out.println("Error inserting user: "+ex);
		}
		finally {
			try {
				updateUserStatement.close();
				connection.close();
			}
			catch(SQLException e) {
				//TO DO: Log error
				System.out.println("Error closing statement: "+e);
			}
		}
		
		return result;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public ResultSet get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int execute() {
		// TODO Auto-generated method stub
		return -1;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getId() {
		return id;
	}

}
