package com.me.coopapp.screen.game;

import java.util.HashMap;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.me.coopapp.Screen;
import com.me.coopapp.ScreenState;
import com.me.coopapp.ui.GdxButton;
import com.me.coopapp.ui.GdxIcon;
import com.me.coopapp.ui.GdxSwitchScreenBtn;
import com.me.coopapp.ui.ObserverSwitchScreen;
import com.me.coopapp.ui.UIPublisher;
import com.me.coopapp.ui.game.ObserverPlayRound;

public class PlayGameScreen extends Screen {
	
	public PlayGameScreen() {
		
	}
	
	public void SetUI() {
	
		
//		final GdxButton playerBtn = new GdxButton("PlayerSmallBtn", -100, 50, ScreenState.Types.playGameTexture);
//		playerBtn.addObserver(new ObserverSwitchScreen());
//		playerBtn.addListener(new ClickListener() {
//		    public void clicked(InputEvent event, float x, float y) {
//
//		    	HashMap<UIPublisher.ParameterType, Object> parameters = new HashMap<UIPublisher.ParameterType, Object>();
//		    	parameters.put(UIPublisher.ParameterType.SCREEN, ScreenState.Types.playerDetailsTexture);
//		    	
//		    	playerBtn.publisher.notifyObservers(parameters);
//		    }
//		  });
		
		new GdxSwitchScreenBtn("PlayerSmallBtn", -100, 50, ScreenState.Types.playerDetailsTexture, ScreenState.Types.playGameTexture);

		
		
//		final GdxButton oppBtn = new GdxButton("OpponentSmallBtn", 100, 150, ScreenState.Types.playGameTexture);
//		oppBtn.addObserver(new ObserverSwitchScreen());
//		oppBtn.addListener(new ClickListener() {
//		    public void clicked(InputEvent event, float x, float y) {
//
//		    	HashMap<UIPublisher.ParameterType, Object> parameters = new HashMap<UIPublisher.ParameterType, Object>();
//		    	parameters.put(UIPublisher.ParameterType.SCREEN, ScreenState.Types.playerDetailsTexture);
//		    	
//		    	oppBtn.publisher.notifyObservers(parameters);
//		    }
//		  });
		
		new GdxSwitchScreenBtn("OpponentSmallBtn", 100, 150, ScreenState.Types.playerDetailsTexture, ScreenState.Types.playGameTexture);

		
		
		new GdxIcon("PlayerChatbox1", 0, 50, ScreenState.Types.playGameTexture);
		new GdxIcon("OpponentChatBox1", 45, 150, ScreenState.Types.playGameTexture);	
		
		new GdxSwitchScreenBtn("PlayGameBtn", 50, -100, ScreenState.Types.playInteractionTexture, ScreenState.Types.playGameTexture).addObserver(new ObserverPlayRound());

	}

}
