package com.me.coopapp.screen.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.me.cooapp.player.Information;
import com.me.cooapp.player.Player;
import com.me.coopapp.Screen;
import com.me.coopapp.ScreenState;
import com.me.coopapp.strategy.Expression;
import com.me.coopapp.strategy.Strategy;
import com.me.coopapp.ui.GdxSwitchScreenBtn;
import com.me.coopapp.ui.UIPublisher;
import com.me.coopapp.ui.game.ListenerStartGame;

public class GameworldScreen extends Screen {
	
	public GameworldScreen() {
		
	}
	
	public void SetUI() {
		
		final GdxSwitchScreenBtn btn = new GdxSwitchScreenBtn("PlayGameBtn", 0, 0, ScreenState.Types.playGameTexture, ScreenState.Types.gameWorldTexture);
		
    	//TODO: Retrieve actual players
		final HashMap<Player.Type, Player> players = new HashMap<Player.Type, Player>();
		players.put(Player.Type.User, new Player().create());
		players.put(Player.Type.Opponent, new Player().create());
		
		//Add click listener
		btn.addListener(new ListenerStartGame());
		btn.setListener(new ClickListener() {
		    public void clicked(InputEvent event, float x, float y) {
		    	
		    	HashMap<UIPublisher.ParameterType, Object> parameters = new HashMap<UIPublisher.ParameterType, Object>();
		    	parameters.put(UIPublisher.ParameterType.PLAYERS, players);
		    	
		    	btn.publisher.notifyObservers(parameters);
		    }
		  });
	}

}
