package com.me.coopapp;
import java.sql.*;
import java.util.*;

public class UserTasks implements IUnitOfWork {
	
	private ArrayList<IEntity> Tasks;
	private Connection conn;
	
	public UserTasks() {
		Tasks = new ArrayList<IEntity>();
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
		
//		private static Connection conn;
		private static Statement stmt;
		private static String Query;

		@Override
		public void setTransaction(String query) {
//			try {
//				stmt = conn.createStatement();
//				Query = query;
//			}
//			catch(SQLException e) {
//			
//			}
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
