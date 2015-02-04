package com.me.coopapp.gamestate;

import com.me.coopapp.game.GameEngine;
import com.me.coopapp.gamestate.GameStateItem.NextThreadAction;

public class PlayRoundTask implements IGLGPerform {
	
	private NextThreadAction isNextAction;

	@Override
	public NextThreadAction getIsNextAction() {
		return isNextAction ;
	}

	@Override
	public Object perform(Object parameter) {

		GameEngine.get().getGame().playRound();
		
		return null;
	}

	@Override
	public void setIsNextAction(NextThreadAction action) {
		isNextAction = action;
		
	}

}
