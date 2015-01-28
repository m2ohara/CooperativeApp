package com.me.coopapp.screen.game;

import com.me.coopapp.Screen;
import com.me.coopapp.ScreenState;
import com.me.coopapp.ui.GdxSwitchScreenBtn;

public class GameworldScreen extends Screen {
	
	public GameworldScreen() {
		
	}
	
	public void SetUI() {
		
		new GdxSwitchScreenBtn("PlayGameBtn", 0, 0, ScreenState.Types.playGameTexture);
	}

}
