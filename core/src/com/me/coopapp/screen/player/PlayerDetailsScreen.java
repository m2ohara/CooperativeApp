package com.me.coopapp.screen.player;

import com.me.coopapp.Screen;
import com.me.coopapp.ScreenState;
import com.me.coopapp.ui.GdxSwitchScreenBtn;

public class PlayerDetailsScreen extends Screen {
	
	public PlayerDetailsScreen() {
		
	}
	
	public void SetUI() {
		
		new GdxSwitchScreenBtn("PlayGameBtn", 0, 0, ScreenState.Types.playGameTexture);
		
	}

}
