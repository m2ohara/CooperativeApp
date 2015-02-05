package com.me.coopapp.game.tasks;

import com.me.coopapp.ScreenState;
import com.me.coopapp.game.Game;
import com.me.coopapp.game.GameEngine;
import com.me.coopapp.gamestate.GameState;
import com.me.coopapp.gamestate.GameStateItem.NextThreadAction;
import com.me.coopapp.gamestate.GdxGameStateItem;
import com.me.coopapp.gamestate.IGLGPerform;
import com.me.coopapp.strategy.Expression;
import com.me.coopapp.ui.GdxIcon;

public class UpdateGameState implements IGLGPerform {
	
	private int expressionXCentreOffset = 150;
	private int expressionYCentreOffset = 150;
	private NextThreadAction isNextAction;

	@Override
	public NextThreadAction getIsNextAction() {
		return isNextAction ;
	}

	@Override
	public void setIsNextAction(NextThreadAction action) {
		isNextAction = action;
	}

	@Override
	public Object perform() {
		
		//Get expression to display for next round
		Expression expression = (Expression)GameEngine.get().getGame().getStatus(Game.statusType.playerExpression);
		GameState.get().addTask(new GdxGameStateItem(new GdxIcon(expression.getTexture(), expressionXCentreOffset, expressionYCentreOffset, ScreenState.Types.gameWorldTexture)));
		return null;
	}

}
