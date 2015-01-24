package com.me.cooapp.player;

public class Player {
	
	public Player() {}
	
	private Information information;

	public Information getInformation() {
		return information;
	}

	public void setInformation(Information information) {
		this.information = information;
	}
	
	public enum Type{ User, Opponent }

}
