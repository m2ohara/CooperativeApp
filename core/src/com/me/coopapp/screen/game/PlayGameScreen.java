package com.me.coopapp.screen.game;

import com.me.cooapp.ui.game.ListenerPlayRound;
import com.me.coopapp.Screen;
import com.me.coopapp.ScreenState;
import com.me.coopapp.ui.GdxIcon;
import com.me.coopapp.ui.GdxSwitchScreenBtn;

public class PlayGameScreen extends Screen {
	
	public PlayGameScreen() {
		
	}
	
	public void SetUI() {
		
		new GdxSwitchScreenBtn("PlayerSmallBtn", -100, 50, ScreenState.Types.playerDetailsTexture, ScreenState.Types.playGameTexture);
		new GdxSwitchScreenBtn("OpponentSmallBtn", 100, 150, ScreenState.Types.playerDetailsTexture, ScreenState.Types.playGameTexture);
		new GdxIcon("PlayerChatbox1", 0, 50, ScreenState.Types.playGameTexture);
		new GdxIcon("OpponentChatBox1", 45, 150, ScreenState.Types.playGameTexture);	
		
		new GdxSwitchScreenBtn("PlayGameBtn", 50, -150, ScreenState.Types.playInteractionTexture, ScreenState.Types.playGameTexture).addListener(new ListenerPlayRound());
	}

}
