package com.me.cooapp.ui.game;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import com.me.coopapp.gamestate.GEGameStateItem;
import com.me.coopapp.gamestate.GameState;
import com.me.coopapp.ui.UIPublisher;

public class ListenerStartGame implements Observer {

	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable arg0, Object arg) {
		
		HashMap<UIPublisher.ParameterType, Object> param = (HashMap<UIPublisher.ParameterType, Object>)arg;
		
		if(param.containsKey(UIPublisher.ParameterType.PLAYERS)) {
		//TODO: Resolve GEGameStateItem removal from items list
		//Start game for provided players
		GameState.get().addTask(new GEGameStateItem(param.get(UIPublisher.ParameterType.PLAYERS)));
		}
	}

}
