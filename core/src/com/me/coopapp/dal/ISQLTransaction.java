package com.me.coopapp.dal;

import java.sql.ResultSet;

public interface ISQLTransaction {
	
	public ResultSet performTransaction();
	
	public void setTransaction(TransactionType _type);
	
	public TransactionType getTransaction();
	
	public enum TransactionType { INSERT, UPDATE, GET, DELETE};

}
