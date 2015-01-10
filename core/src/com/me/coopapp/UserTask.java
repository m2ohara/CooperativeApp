package com.me.coopapp;

import java.sql.ResultSet;

import com.me.coopapp.dal.ISQLTransaction;
import com.me.coopapp.entity.User;

public class UserTask implements ITask, ISQLTransaction {

	private TransactionType transaction;
	public boolean isTaskComplete = false;
	
	public UserTask() {
		
	}

	@Override
	public void perform(boolean isGdxThread) {
		performTransaction();
		
	}

	@Override
	public boolean isTaskComplete() {
		return isTaskComplete;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ResultSet performTransaction() {
		
		if(transaction == TransactionType.INSERT) {
			User.getInstance().insert();
			
			isTaskComplete = true;
		}
		else if(transaction == TransactionType.UPDATE) {
			User.getInstance().update();
			
			isTaskComplete = true;
		}
		
		return null;
	}

	@Override
	public void setTransaction(TransactionType _type) {
		transaction = _type;
	}

	@Override
	public TransactionType getTransaction() {
		return transaction;
	}

}
