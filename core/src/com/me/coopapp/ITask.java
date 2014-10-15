package com.me.coopapp;

public interface ITask {
	
	public void Perform(boolean isGdxThread);
	
	public Object getTaskItems();
	
	public void Dispose();

}
