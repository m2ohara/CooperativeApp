package com.me.coopapp.game;

import java.util.Dictionary;

import com.me.cooapp.player.Player;

public class Game implements IGame {
	
	public Game() {
		
	}
	
	Dictionary<Player.Type, Player> players;
	private int rounds;
	private int[] score;
	
	public Object playRound() {
		
		return new Object();
	}
	
	public void play() {
		
	}
	
	public enum Type { Discrete, Continuous}

}
