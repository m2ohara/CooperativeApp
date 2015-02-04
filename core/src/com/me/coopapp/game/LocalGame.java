package com.me.coopapp.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.me.cooapp.player.Player;
import com.me.coopapp.strategy.Expression;

public class LocalGame extends Game {

	public LocalGame(
			HashMap<com.me.cooapp.player.Player.Type, Player> players) {
		super(players);

	}
	
	private int rounds;
	private int currentRound = 0;
	private ArrayList<Expression> playerStrategy;
	private ArrayList<Expression> opponentStrategy;
	
	@Override
	public void setGame() {
		
		rounds = (int) (Math.random() * 10);
		playerStrategy = players.get(Player.Type.User).getInformation().getStrategy().getExpressions();
		opponentStrategy = players.get(Player.Type.Opponent).getInformation().getStrategy().getExpressions();
		gameRules = new GameRules();
		gameStatus.put(statusType.playerExpression, playerStrategy.get(currentRound));
		
		//TODO: Persist game data
	}

	@Override
	public void playRound() {
		
		//Get player expressions for current round
		Expression playerExp = playerStrategy.get((int)currentRound % opponentStrategy.size());
		Expression opponExp = opponentStrategy.get((int)currentRound % opponentStrategy.size());
		
		//Play round
		@SuppressWarnings("unchecked")
		ArrayList<Integer> points = (ArrayList<Integer>)getRoundOutcome(new ArrayList<Expression>(Arrays.asList(playerExp, opponExp)));
		currentRound++;
		
		//Update game
		
	}
	
	private void UpdateGame() {
		
		gameStatus.put(statusType.playerExpression, playerStrategy.get(currentRound));
	}

}
