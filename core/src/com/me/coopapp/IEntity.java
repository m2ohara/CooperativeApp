package com.me.coopapp;

import org.sqlite.SQLiteConnection;

public interface IEntity {
	
	public void Insert();
	
	public void Update();
	
	public Object Get();
	
	public Object GetById(int id);
	
	public void Execute();

}
