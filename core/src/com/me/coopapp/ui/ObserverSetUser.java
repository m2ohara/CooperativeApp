package com.me.coopapp.ui;

import java.util.Observable;
import java.util.Observer;
import com.me.coopapp.UserState;

public class ObserverSetUser implements Observer {
	
	private ObservableType type;
	
	public ObserverSetUser(ObservableType _type) {
		type = _type;
	}
	

	@Override
	public void update(Observable o, Object arg) {
		if(type == ObservableType.EMAIL) {
			UserState.getInstance().setEmail((String) arg);
		}
		if(type == ObservableType.NAME) {
			UserState.getInstance().setName((String) arg);
		}
		if(type == ObservableType.ALIAS) {
			UserState.getInstance().setAlias((String) arg);
		}
		
	}
	
	public ObservableType getType() {
		return type;
	}

	public void setType(ObservableType type) {
		this.type = type;
	}

	public enum ObservableType { EMAIL, NAME, ALIAS }
}
