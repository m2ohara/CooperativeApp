package com.me.coopapp.game;

import java.util.Dictionary;

import com.me.cooapp.player.Player;

public class GameEngine {
	
	private static GameEngine instance;
	Dictionary<Player.Type, Player> players;
	private Game.Type gameType;
	private IGame game;
	
	private GameEngine() {

	}
	
	public static GameEngine get() {
		if(instance == null) {
			instance = new GameEngine();
		}
		return instance;
	}
	
	public IGame getGame() {
		return game;
	}

	public void setGame(IGame game) {
		this.game = game;
	}

	public void setGame(Dictionary<Player.Type, Player> players) {
		this.players = players;
	}
	
	public void play() {
			
	}
	
	private void updatePlayer() {
		
	}

}
