package com.me.coopapp.game.tasks;

import java.util.HashMap;

import com.me.cooapp.player.Player;
import com.me.cooapp.player.Player.Type;
import com.me.coopapp.game.GameEngine;
import com.me.coopapp.gamestate.GameStateItem;
import com.me.coopapp.gamestate.IGLGPerform;
import com.me.coopapp.gamestate.GameStateItem.NextThreadAction;

public class StartGame implements IGLGPerform {
	
	private HashMap<Type, Player> players;
	private NextThreadAction isNextAction;
	
	public StartGame(HashMap<Type, Player> players) {
		this.players = players;
		this.isNextAction = NextThreadAction.YES;
	}
	
	@Override
	public Object perform() {

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
