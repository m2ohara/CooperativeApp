package com.me.coopapp;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.me.coopapp.dal.ISQLTransaction;
import com.me.coopapp.entity.Database;

public class DbSetup implements ISQLTransaction {
	
	private static DbSetup instance;
	private TransactionType type;
	public boolean isDB = false;
	
	private DbSetup() {
	}
	
	public static DbSetup getInstance() {
		if(instance == null) {
			instance = new DbSetup();
		}
		return instance;
	}

	@Override
	public ResultSet performTransaction() {
		
		if(type == TransactionType.INSERT) {
			//Create DB
			Database.getInstance().insert();
		}
		
		else if(type == TransactionType.GET) {
			//Get DB tables
			try {
				if(!Database.getInstance().get().next()) {
					//If tables do not exist, create DB 
					Database.getInstance().insert();
				}
				
				//Set screen
				ScreenState.getScreenInstance().setTask(Types.ScreenTypes.register1Texture);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void setTransaction(TransactionType _type) {
		type = _type;
		
	}

	@Override
	public TransactionType getTransaction() {
		return type;
	}
	
	//************* Refactor out ***************//
	//Check if database is setup
//	public boolean isTableExists() {
//		
//		boolean hasFirstTable = false;
//		try {
//			hasFirstTable = new GetTables().performTransaction().next();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return hasFirstTable;
//	}
//	
//	//Create database
//	public int createDatabaseFromFile() {
//		
//		return new CreateDB().PerformTransaction();
//		
//	}

}
