package com.me.coopapp.strategy;

import java.util.Map;

import com.me.coopapp.game.Game;

public class ExpressionNice implements IExpression {

	@Override
	public int translateToInteraction(Map<Game.statusType, Object> gameStatus) {

		//Expression is only applied for first game interaction, afterwards its a random result
		if((Integer)gameStatus.get("round") == 0) {
			return 1;
		}
		
		return Math.random() > 0.5 ? 1 : 0;
	}

}
