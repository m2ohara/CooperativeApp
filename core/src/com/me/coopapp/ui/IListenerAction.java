package com.me.coopapp.ui;

public interface IListenerAction {
	
	public void performListenerAction();
	
	public void setListenerActionType(ListenerActionType _type);
	
	public ListenerActionType getListenerActionType();
	
	enum ListenerActionType { SETUSEREMAIL, SETUSERNAME };

}
