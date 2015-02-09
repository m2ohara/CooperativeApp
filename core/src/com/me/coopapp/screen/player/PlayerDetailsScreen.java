package com.me.coopapp.screen.player;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.me.coopapp.Screen;
import com.me.coopapp.ScreenState;
import com.me.coopapp.ui.GdxSwitchScreenBtn;
import com.me.coopapp.ui.game.ObserverReturnToGame;

public class PlayerDetailsScreen extends Screen {
	
	public PlayerDetailsScreen() {
		
	}
	
	public void SetUI() {
		
		final GdxSwitchScreenBtn btn = new GdxSwitchScreenBtn("PlayGameBtn", 0, 0, ScreenState.Types.playGameTexture, ScreenState.Types.playerDetailsTexture);
		
		//Add click listener
		btn.addObserver(new ObserverReturnToGame());
		
	}

}
