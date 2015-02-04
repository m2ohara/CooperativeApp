package com.me.cooapp.ui.game;

import java.util.Observable;
import java.util.Observer;

import com.me.coopapp.game.GameEngine;

public class ListenerPlayRound implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		//TODO set game state item task
		GameEngine.get().getGame().playRound();
		
	}

}
