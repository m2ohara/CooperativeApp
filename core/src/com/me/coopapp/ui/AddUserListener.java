package com.me.coopapp.ui;

import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.me.coopapp.GameLogic;
import com.me.coopapp.UserState;

public class AddUserListener implements IListener {
	
	private EventListener listener;

	public AddUserListener() {
		
		listener = new ClickListener() {
		    public void clicked(InputEvent event, float x, float y) {
		    	//Insert current user state to db
		    	UserState.getInstance().addUser();
		    }
		};
		
	}

	@Override
	public EventListener getListener() {
		return listener;
	}

	@Override
	public void setListener(EventListener _listener) {
		listener = _listener;
	}

}
