package com.me.coopapp;

public interface ITask {
	
	public void perform(boolean isGdxThread);
	
	public boolean isTaskComplete();
	
	public void dispose();
	
	public void cleanUpTask();

}
