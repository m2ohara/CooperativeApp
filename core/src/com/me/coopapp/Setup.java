package com.me.coopapp;

//import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.sqlite.SQLiteConnection;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class Setup {
	
	private SQLiteConnection connection;
	
	//TO DO: Set up dependency injection
	public Setup(SQLiteConnection conn) {
		connection = conn;
	}
	
	//Check if database is setup
	public boolean isTableExists() {
		
		boolean hasFirstTable = false;
		ResultSet queryResult = null;
		
		try {
			
			DatabaseMetaData meta = connection.getMetaData();
			queryResult = meta.getTables(null, null, null, new String[] {"TABLE"});
			

			hasFirstTable = queryResult.next();
		}
		catch(SQLException ex) {
			System.out.println("Error getting tables: "+ex);
		}
		
		return hasFirstTable;
	}
	
	//Create database
	public int createDatabaseFromFile() {
		
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
