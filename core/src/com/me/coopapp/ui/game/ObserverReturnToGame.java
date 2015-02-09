package com.me.coopapp.ui.game;

import java.util.LinkedHashMap;
import java.util.Observable;
import java.util.Observer;

import com.me.coopapp.ScreenState;
import com.me.coopapp.game.GameEngine;
import com.me.coopapp.game.tasks.UpdateGameState;
import com.me.coopapp.gamestate.GameState;
import com.me.coopapp.gamestate.GameStateItem.NextThreadAction;
import com.me.coopapp.gamestate.GlgGameStateItem;
import com.me.coopapp.gamestate.IGLGPerform;

public class ObserverReturnToGame implements Observer {

	@Override
	public void update(Observable arg0, Object arg1) {
		//Add tasks for perform during game load
		LinkedHashMap<Integer, IGLGPerform> tasksToPerform = new LinkedHashMap<Integer, IGLGPerform>();
		IGLGPerform task = new UpdateGameState();
		task.setIsNextAction(NextThreadAction.YES);
		tasksToPerform.put(new Integer(task.hashCode()), task);
		
		GameState.get().addTask(new GlgGameStateItem(GameEngine.get(), tasksToPerform, ScreenState.Types.playGameTexture));

	}

}
