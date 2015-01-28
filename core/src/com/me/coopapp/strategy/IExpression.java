package com.me.coopapp.strategy;

import java.util.Map;

import com.me.coopapp.game.Game;

public interface IExpression {
	
	public int translateToInteraction(Map<Game.statusType, Object> gameStatus);

}
