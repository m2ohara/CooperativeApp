package com.me.coopapp.dal;

import java.sql.Connection;

import com.me.coopapp.IActionResolver;

//import org.sqlite.SQLiteConnection;

public class SQLConnection {
	
	private static IActionResolver sqlActionResolver;
	
	public SQLConnection(IActionResolver conn) {
		sqlActionResolver = conn;
	}
	
	public static Connection get() {
		return sqlActionResolver.getConnection();
	}
	
	
}
