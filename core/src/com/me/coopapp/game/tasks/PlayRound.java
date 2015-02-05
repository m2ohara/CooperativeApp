package com.me.coopapp.game.tasks;

import com.me.coopapp.game.GameEngine;
import com.me.coopapp.gamestate.GameStateItem;
import com.me.coopapp.gamestate.IGLGPerform;
import com.me.coopapp.gamestate.GameStateItem.NextThreadAction;

public class PlayRound implements IGLGPerform {
	
	private NextThreadAction isNextAction;
	
	public PlayRound() {
		this.isNextAction = NextThreadAction.YES;
	}

	@Override
	public NextThreadAction getIsNextAction() {
		return isNextAction ;
	}

	@Override
	public Object perform() {

		GameEngine.get().getGame().playRound();
		
		return null;
	}

	@Override
	public void setIsNextAction(NextThreadAction action) {
		isNextAction = action;
		
	}

}
