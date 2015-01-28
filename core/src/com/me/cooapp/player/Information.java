package com.me.cooapp.player;

import com.me.coopapp.strategy.Strategy;

public class Information {
	
	public Information() {
		
	}
	
	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	private Strategy strategy;
	
	private int Votes;
	private int Reputation;
	
}
