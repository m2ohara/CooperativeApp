package com.me.coopapp.ui;

import com.me.coopapp.UserState;

public class TextFieldListenerAction extends ListenerAction {
	
	public String value;
	
	public TextFieldListenerAction(ListenerActionType _lType, String _value) {
		super(_lType);
		
		value = _value;
	}
			
	
	public void performListenerAction() {
		if(lType == ListenerActionType.SETUSEREMAIL) {
			UserState.getInstance().setEmail(value);
		}
		if(lType == ListenerActionType.SETUSERNAME) {
			UserState.getInstance().setName(value);
		}
	}

}
