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
	
	private HashMap<Player.Type, Player> players;
	private int rounds;
	private int currentRound = 0;
	private int[] score;
	private ArrayList<Expression> playerStrategy;
	private ArrayList<Expression> opponentStrategy;
	
	private Map<statusType, Object> gameStatus = new HashMap<statusType, Object>();	
	public enum statusType {Round, PrevInteractions}
	
	public void setGame() {
		
		rounds = (int) (Math.random() * 10);
		playerStrategy = players.get(Player.Type.User).getInformation().getStrategy().getExpressions();
		opponentStrategy = players.get(Player.Type.Opponent).getInformation().getStrategy().getExpressions();
	}
	
	public void play() {
		
		//Get player expressions for current round
		Expression playerExp = playerStrategy.get((int)currentRound % opponentStrategy.size());
		Expression opponExp = opponentStrategy.get((int)currentRound % opponentStrategy.size());
		
		//Play round
		playRound(new ArrayList<Expression>(Arrays.asList(playerExp, opponExp)));
		
		//Calculate results
		
	}
	
	private Object playRound(ArrayList<Expression> expressions) {
		
		ArrayList<Integer> interactions = new ArrayList<Integer>();
		
		for(Expression e : expressions) {
			interactions.add(translateExpression(e));
		}
		
		//Use game rules to determine score
		
		return new Object();
	}
	
	private int translateExpression(Expression expression) {
		
		ArrayList<Integer> previousInteractions = new ArrayList<Integer>();	
		
		int result = expression.translateToInteraction(gameStatus);
		
		previousInteractions.add(result);

		return result;
	}
	
	public enum Type { Discrete, Continuous}

}
