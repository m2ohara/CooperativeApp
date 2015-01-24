package com.me.coopapp.game;

import java.util.Dictionary;

import com.me.cooapp.player.Player;

public class GameEngine {
	
	private static GameEngine instance;
	Dictionary<Player.Type, Player> players;
	private Game.Type gameType;
	
	private GameEngine() {

	}
	
	public GameEngine get() {
		if(instance == null) {
			instance = new GameEngine();
		}
		return instance;
	}
	
	public void setGame(Dictionary<Player.Type, Player> players) {
		this.players = players;
	}
	
	public void play() {
			
	}
	
	private void updatePlayer() {
		
	}

}
