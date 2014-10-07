package com.me.coopapp;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import org.sqlite.SQLiteConnection;

public class SQLConnection {
	
	public static SQLiteConnection connection;
	public static DatabaseMetaData metaData;

	//TO DO: Singleton
	public SQLConnection(SQLiteConnection _conn) {
		connection = _conn;
	}
	
	public static SQLiteConnection getConnection() {
		if(connection == null) {
			//Instantiate new connection
			try {
				connection = (SQLiteConnection) metaData.getConnection();
			}
			catch(SQLException e) {
				System.out.println("Error getting connection "+e);
			}
		}
		
		return connection;
	}
	
}
