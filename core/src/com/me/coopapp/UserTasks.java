package com.me.coopapp;
import java.sql.*;
import java.util.*;

import org.sqlite.SQLiteConnection;

public class UserTasks implements IUnitOfWork {
	
	private ArrayList<IEntity> Tasks;
	
	public UserTasks() {
		Tasks = new ArrayList<IEntity>();
	}

	@Override
	public IUnitOfWork startTransaction(ITransaction transaction) {
		
		//For each task
		for(IEntity task : Tasks) {
			transaction.setTransaction("");
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
				stmt = SQLConnection.connection.createStatement();
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
