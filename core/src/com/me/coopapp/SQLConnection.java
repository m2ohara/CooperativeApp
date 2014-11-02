package com.me.coopapp;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Connection;

//import org.sqlite.SQLiteConnection;

public class SQLConnection {
	
	public static Connection connection;
	public static DatabaseMetaData metaData;

	//TO DO: Singleton
	public SQLConnection(Connection _conn) {
		connection = _conn;
	}
	
	public static Connection getConnection() {
		if(connection == null) {
			//Instantiate new connection
			try {
				connection = (Connection) metaData.getConnection();
			}
			catch(SQLException e) {
				System.out.println("Error getting connection "+e);
			}
		}
		
		return connection;
	}
	
}
