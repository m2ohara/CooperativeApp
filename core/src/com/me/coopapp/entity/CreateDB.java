package com.me.coopapp.entity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.me.coopapp.dal.SQLConnection;

public class CreateDB {
	
	private Connection connection;
	
	public CreateDB() {
		connection = SQLConnection.get();
	}

	public int PerformTransaction() {
		Statement createDBStatement = null;
		
		//Get sql from file
		FileHandle createDBFile = Gdx.files.internal("sampleDB.sql");
		String fileSQL = createDBFile.readString();
		
		//Initialise as false
		int result = -1;
		
		try {
			
			//Create database tables
			createDBStatement = connection.createStatement();
			result = createDBStatement.executeUpdate(fileSQL);
		}
		catch(SQLException ex) {
		//TO DO: Log error
			System.out.println("Error creating database: "+ex);
		}
		finally {
			try {
				createDBStatement.close();
				connection.close();
			}
			catch(SQLException e) {
				
			}
		}
		return result;
	}

}
