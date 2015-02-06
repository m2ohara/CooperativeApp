package com.me.coopapp.ui;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import com.me.coopapp.ScreenState;

public class ObserverSwitchScreen implements Observer {

	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable o, Object arg) {
		HashMap<UIPublisher.ParameterType, Object> param = (HashMap<UIPublisher.ParameterType, Object>)arg;
		//If expected parameter
		if(param.containsKey(UIPublisher.ParameterType.SCREEN)) {
	    	//Set screen to switch to on click
	    	new ScreenState((ScreenState.Types)param.get(UIPublisher.ParameterType.SCREEN));
		}
	}

}
