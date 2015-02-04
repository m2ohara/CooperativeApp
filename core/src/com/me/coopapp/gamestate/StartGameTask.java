package com.me.coopapp.gamestate;

import java.util.HashMap;

import com.me.cooapp.player.Player;
import com.me.cooapp.player.Player.Type;
import com.me.coopapp.game.GameEngine;
import com.me.coopapp.gamestate.GameStateItem.NextThreadAction;

public class StartGameTask implements IGLGPerform {
	
	private HashMap<Type, Player> players;
	private NextThreadAction isNextAction;
	
	public StartGameTask(HashMap<Type, Player> players) {
		this.players = players;
		isNextAction = NextThreadAction.YES;
	}
	
	@Override
	public Object perform(Object object) {

		GameEngine.get().startGame(players);
		
		return null;
	}

	@Override
	public NextThreadAction getIsNextAction() {
		return isNextAction ;
	}

	@Override
	public void setIsNextAction(NextThreadAction action) {
		isNextAction = action;
	}

}
