package com.me.coopapp.dal.transaction;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.me.coopapp.dal.ISQLTransaction;
import com.me.coopapp.dal.SQLConnection;

public class GetTables implements ISQLTransaction {
	
	private Connection connection;
	
	public GetTables() {
		connection = SQLConnection.get();
	}

	@Override
	public ResultSet performTransaction() {
		ResultSet queryResult = null;
		
		try {
			
			DatabaseMetaData meta = connection.getMetaData();
			queryResult = meta.getTables(null, null, null, new String[] {"TABLE"});
			
		}
		catch(SQLException ex) {
			System.out.println("Error getting tables: "+ex);
		}
		
		return queryResult;
		
	}

	@Override
	public void setTransaction(TransactionType _type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TransactionType getTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

}
