package com.me.coopapp;

import java.sql.SQLException;

import com.me.coopapp.dal.transaction.CreateDB;
import com.me.coopapp.dal.transaction.GetTables;
//import org.sqlite.SQLiteConnection;

public class Setup {
	
	public Setup() {
	}
	
	//Check if database is setup
	public boolean isTableExists() {
		
		boolean hasFirstTable = false;
		try {
			hasFirstTable = new GetTables().PerformTransaction().next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return hasFirstTable;
	}
	
	//Create database
	public int createDatabaseFromFile() {
		
		return new CreateDB().PerformTransaction();
		
	}

}
