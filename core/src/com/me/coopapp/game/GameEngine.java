package com.me.coopapp.game;

import java.util.HashMap;

import com.me.cooapp.player.Player;

public class GameEngine {
	
	private static GameEngine instance;
	private HashMap<Player.Type, Player> players;
	private Game.Type gameType;
	private IGame game;
	
	private GameEngine(Game.Type gameType) {
		this.gameType = gameType;
	}
	
	public static GameEngine get() {
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
	}

}
