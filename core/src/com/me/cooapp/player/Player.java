package com.me.cooapp.player;

import com.me.coopapp.strategy.Strategy;

public class Player {
	
	private Strategy playingStrategy;
	private Information information;
	private Type type;
	
	public Player() {}
	
	public Player(Information information) {
		this.information = information;
	}

	public Information getInformation() {
		return information;
	}

	public void setInformation(Information information) {
		this.information = information;
	}
	
	public Strategy playingStrategy() {
		return this.playingStrategy;
	}
	
	public Player create() {
		playingStrategy = new Strategy().createRandomStrategy();
		return this;
	}
	
	public enum Type{ User, Opponent }

}
