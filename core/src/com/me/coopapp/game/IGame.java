package com.me.coopapp.game;

import java.util.Map;

import com.me.coopapp.game.Game.statusType;

public interface IGame {
	
	public void setGame();

	public void playRound();
	
	public Object gameStatus(statusType type);
}
