package com.me.coopapp;

import org.sqlite.SQLiteConnection;
import org.sqlite.core.DB;

public class SQLConnection {
	
	private static SQLiteConnection connection;
	private static DB connectionCore;

	//TO DO: Singleton
	public SQLConnection(SQLiteConnection _conn) {
		connection = _conn;
	}
	
	public static SQLiteConnection getConnection() {
		if(connection == null) {
			//Instantiate new connection
		}
		
		return connection;
	}
	
}
