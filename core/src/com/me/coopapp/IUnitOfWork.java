package com.me.coopapp;

public interface IUnitOfWork {
	
	void Commit();
	
	IUnitOfWork startTransaction(ITransaction transaction);
	
	public interface ITransaction {
		void execute();
		void setTransaction(String query);
	}

}
