package com.me.coopapp;

import java.sql.ResultSet;

public interface IEntity {
	
	public int insert();
	
	public int update();
	
	public int delete();
	
	public ResultSet get();
	
	public ResultSet getById(int id);
	
	public int execute();

}
