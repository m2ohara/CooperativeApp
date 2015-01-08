package com.me.coopapp.ui;

import java.util.Observable;
import java.util.Observer;

import com.me.coopapp.UserState;

public class ListenerUpdateUser implements Observer {

	@Override
	public void update(Observable o, Object arg) {
    	//Update current user state to db
    	UserState.getInstance().setUpdateUserTask();
	}
}
