package com.me.coopapp.ui.game;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;

import com.me.cooapp.player.Player;
import com.me.cooapp.player.Player.Type;
import com.me.coopapp.game.GameEngine;
import com.me.coopapp.game.tasks.StartGame;
import com.me.coopapp.game.tasks.UpdateGameState;
import com.me.coopapp.gamestate.GameState;
import com.me.coopapp.gamestate.GlgGameStateItem;
import com.me.coopapp.gamestate.IGLGPerform;
import com.me.coopapp.strategy.Expression;
import com.me.coopapp.ui.GdxIcon;
import com.me.coopapp.ui.UIPublisher;

public class ListenerStartGame implements Observer {

	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable arg0, Object arg) {
		
		HashMap<UIPublisher.ParameterType, Object> param = (HashMap<UIPublisher.ParameterType, Object>)arg;
		
		if(param.containsKey(UIPublisher.ParameterType.PLAYERS)) {
			//Start game for provided players
//			GameState.get().addTask(new GEGameStateItem());
			
			//Set players for the game
			HashMap<Type, Player> players = (HashMap<Type, Player>)param.get(UIPublisher.ParameterType.PLAYERS);
			GameEngine.get().setPlayers(players);
			
			//Add tasks for perform during game load
			ConcurrentHashMap<Integer, IGLGPerform> tasksToPerform = new ConcurrentHashMap<Integer, IGLGPerform>();
			tasksToPerform.put(new Integer(0), new StartGame((HashMap<Type, Player>) players));
			tasksToPerform.put(new Integer(1), new UpdateGameState());
			
			GameState.get().addTask(new GlgGameStateItem(GameEngine.get(), tasksToPerform));
		}
	}

}
