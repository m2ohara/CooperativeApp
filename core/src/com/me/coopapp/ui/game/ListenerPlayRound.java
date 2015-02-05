package com.me.coopapp.ui.game;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;

import com.me.coopapp.ScreenState;
import com.me.coopapp.game.GameEngine;
import com.me.coopapp.game.tasks.PlayRound;
import com.me.coopapp.game.tasks.UpdateGameState;
import com.me.coopapp.gamestate.GameState;
import com.me.coopapp.gamestate.GlgGameStateItem;
import com.me.coopapp.gamestate.IGLGPerform;

public class ListenerPlayRound implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		
		//Add tasks for perform during game load
		ConcurrentHashMap<Integer, IGLGPerform> tasksToPerform = new ConcurrentHashMap<Integer, IGLGPerform>();
		tasksToPerform.put(new Integer(0), new PlayRound());
		tasksToPerform.put(new Integer(1), new UpdateGameState());
		
		GameState.get().addTask(new GlgGameStateItem(GameEngine.get(), tasksToPerform, ScreenState.Types.playGameTexture));
		
	}

}
