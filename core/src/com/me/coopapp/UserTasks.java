package com.me.coopapp;
import java.sql.*;
import java.util.*;

import org.sqlite.SQLiteConnection;

public class UserTasks implements IUnitOfWork {
	
	private ArrayList<IEntity> Tasks;
	private static SQLiteConnection conn;
	
	public UserTasks(SQLiteConnection _conn) {
		Tasks = new ArrayList<IEntity>();
		conn = _conn;
	}

	@Override
	public IUnitOfWork startTransaction(ITransaction transaction) {
		
		for(IEntity task : Tasks) {
			task.Get();
		}
		
		return null;
	}
	
	@Override
	public void Commit() {
		// TODO Auto-generated method stub

	}
	
	//Transaction behaviour
	static class UserTransaction implements IUnitOfWork.ITransaction {
		
		private static Statement stmt;
		private static String Query;

		@Override
		public void setTransaction(String query) {
			try {
				stmt = conn.createStatement();
				Query = query;
			}
			catch(SQLException e) {
			
			}
		}
		
		@Override
		public void execute() {
			
			try {
				ResultSet rs = stmt.executeQuery(Query);
			}
			catch(SQLException e) {
				
			}
			
			
		}
		
	}

}
