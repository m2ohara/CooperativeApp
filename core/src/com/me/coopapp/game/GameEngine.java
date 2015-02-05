package com.me.coopapp.game;

import java.util.HashMap;

import com.me.cooapp.player.Player;
import com.me.coopapp.gamestate.GameStateItem;
import com.me.coopapp.strategy.Expression;

public class GameEngine {
	
	private static GameEngine instance;
	private HashMap<Player.Type, Player> players;
	private Game.Type gameType;
	private IGame game;
	
	private GameEngine(Game.Type gameType) {
		this.gameType = gameType;
	}
	
	public static GameEngine get() {
		//Singleton currently set to return local game
		if(instance == null) {
			instance = new GameEngine(Game.Type.Local);
		}
		return instance;
	}
	
	public IGame getGame() {
		return game;
	}
	
	public void startGame(HashMap<Player.Type, Player> players) {
		this.players = players;
		game = new LocalGame(players);
		game.setGame();
		
		//Set expression for start round
	}
	
	public void setPlayers(HashMap<Player.Type, Player> players) {
		this.players = players;
	}

}
