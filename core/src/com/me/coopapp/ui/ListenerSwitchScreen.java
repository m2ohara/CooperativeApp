package com.me.coopapp.ui;

import java.util.Observable;
import java.util.Observer;

import com.me.coopapp.GameLogic;
import com.me.coopapp.ScreenState;
import com.me.coopapp.Types.ScreenTypes;

public class ListenerSwitchScreen implements Observer {

	@Override
	public void update(Observable o, Object arg) {
    	//Set screen to switch to on click
    	ScreenState.getScreenInstance().type = (ScreenTypes)arg;
    	GameLogic.getInstance().ScreenTasks.add(ScreenState.getScreenInstance());
	}

}
