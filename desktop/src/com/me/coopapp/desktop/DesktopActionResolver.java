package com.me.coopapp.desktop;

import java.sql.Connection;
import com.me.coopapp.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DesktopActionResolver implements IActionResolver {

	@Override
	public Connection getConnection() {
		String url = "jdbc:sqlite:CoopAppDB.sqlite";
		try {
			Class.forName("org.sqlite.JDBC");
			return DriverManager.getConnection(url);
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
