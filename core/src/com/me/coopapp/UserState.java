package com.me.coopapp;

import java.sql.ResultSet;

import com.me.coopapp.dal.ISQLTransaction;
import com.me.coopapp.dal.transaction.User;


public class UserState implements ITask, ISQLTransaction {
	
	private User entity;
	public String imageName;
	private TransactionType type;
	
	public UserState(User _entity) {
		entity = _entity;
	}
	
	@Override
	public void perform(boolean isGdxThread) {
		
		if(!isGdxThread) {
			performTransaction();
		}
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isTaskComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet performTransaction() {
		
		if(type == TransactionType.INSERT) {
			entity.insert();
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
	
	public String getImageName() {
		return imageName;
	}
	
	public void setImageName(String _imageName) {
		imageName = _imageName;
	}
	
	//Set transaction to perform
	public void addUser(String _name, String _email) {
		
		type = TransactionType.INSERT;
		entity.addUser(_name, _email);
		
		GameLogic.getInstance().UserTasks.add(this);
	}
	

}
