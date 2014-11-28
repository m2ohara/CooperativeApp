package com.me.coopapp.ui;

import com.me.coopapp.GameLogic;

public class UserListenerAction extends ListenerAction {
	
	public String value;
	
	public UserListenerAction(ListenerActionType _lType) {
		super(_lType);
	}
			
	
	public void performListenerAction() {
		if(lType == ListenerActionType.SETUSEREMAIL) {
			GameLogic.userEntity.setEmail(value);
		}
		if(lType == ListenerActionType.SETUSERNAME) {
			GameLogic.userEntity.setName(value);
		}
	}

}
