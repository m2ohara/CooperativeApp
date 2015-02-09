package com.me.coopapp.game;

import com.me.coopapp.game.Game.statusType;

public interface IGame {
	
	public void setGame();

	public void playRound();
	
	public Object getStatus(statusType type);
}
