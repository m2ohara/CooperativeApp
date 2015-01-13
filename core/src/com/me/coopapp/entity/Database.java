package com.me.coopapp.entity;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.me.coopapp.dal.SQLConnection;

public class Database implements IEntity {
	
	private static Database instance;
	private static Connection connection;
	
	private Database() {
		connection = SQLConnection.get();
	}
	
	public static Database getInstance() {
		if(instance == null) {
			instance = new Database();
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
		Statement createDBStatement = null;
		
		//Get sql from file
		FileHandle createDBFile = Gdx.files.internal("createDB.sql");
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

	@Override
	public int update() {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return -1;
	}
	
	@Override
	public ResultSet get() {
		ResultSet queryResult = null;
		
		try {
			
			DatabaseMetaData meta = connection.getMetaData();
			queryResult = meta.getTables(null, null, null, new String[] {"TABLE"});
			
		}
		catch(SQLException ex) {
			System.out.println("Error getting tables: "+ex);
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
		return queryResult;
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

}
