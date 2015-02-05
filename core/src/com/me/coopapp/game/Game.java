package com.me.coopapp.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

import com.me.cooapp.player.Player;
import com.me.coopapp.strategy.Expression;

public class Game implements IGame {
	
	public Game(HashMap<Player.Type, Player> players) {
		this.players = players;
	}
	
	protected HashMap<Player.Type, Player> players;
	protected IGameRules gameRules;
	protected Map<statusType, Object> gameStatus = new HashMap<statusType, Object>();	

	public enum statusType {Round, PrevInteractions, Interacting, playerExpression}
	
	public void setGame() {
		
	}
	
	public void playRound() {
		
	}
	
	protected Object getRoundOutcome(ArrayList<Expression> expressions) {
		
		ArrayList<Integer> interactions = new ArrayList<Integer>();
		
		for(Expression e : expressions) {
			interactions.add(translateExpression(e));
		}
		
		//Use game rules to determine score
		return gameRules.getInteractionPoints(interactions);
	}
	
	protected int translateExpression(Expression expression) {
		
		ArrayList<Integer> previousInteractions = new ArrayList<Integer>();	
		
		int result = expression.translateToInteraction(gameStatus);
		
		previousInteractions.add(result);

		return result;
	}
	
	public Object getStatus(statusType type) {
		return gameStatus.get(type);
	}
	
	public enum Type { Local, Remote}

}
