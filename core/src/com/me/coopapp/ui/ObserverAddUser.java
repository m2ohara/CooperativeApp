package com.me.coopapp.ui;

import java.util.Observable;
import java.util.Observer;
import com.me.coopapp.UserState;

public class ObserverAddUser implements Observer {

	@Override
	public void update(Observable o, Object arg) {
    	//Insert current user state to db
    	UserState.getInstance().setAddUserTask();
	}

}
