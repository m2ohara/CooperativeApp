package com.me.coopapp.strategy;

import java.util.Map;

import com.me.coopapp.game.Game;

public class Expression implements IExpression {

	public Expression() {}
	
	public Expression(Type type) {
		this.type = type;
	}
	
	private Type type;
	
	public int translateToInteraction(Map<Game.statusType, Object> gameStatus) {
		return 0;
	}
	
	public enum Type { Nice, Forgiving, Optomist, Selfish }
}

