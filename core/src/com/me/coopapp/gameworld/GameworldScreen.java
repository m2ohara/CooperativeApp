package com.me.coopapp.gameworld;

import com.me.coopapp.Screen;
import com.me.coopapp.Types.ScreenTypes;
import com.me.coopapp.ui.GdxSwitchScreenBtn;

public class GameworldScreen extends Screen {
	
	public void setUI() {
		
		new GdxSwitchScreenBtn("PlayerDetailsBtn", -100, 250, ScreenTypes.gameWorldTexture);
	}

}
