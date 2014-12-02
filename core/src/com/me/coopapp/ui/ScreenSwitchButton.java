package com.me.coopapp.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.me.coopapp.GameLogic;
import com.me.coopapp.ScreenState;
import com.me.coopapp.Types.ScreenTypes;
import com.me.coopapp.gamestate.GameState;
import com.me.coopapp.gamestate.GameStateItem;

public class ScreenSwitchButton extends GdxButton {
	
	public ScreenTypes screenToSwitch;

	public ScreenSwitchButton(String _type, ScreenTypes _screenToSwitch) {
		super(_type);
		screenToSwitch = _screenToSwitch;
	}
	
	public ScreenSwitchButton(String _type, float xCoord, float yCoord, ScreenTypes _screenToSwitch) {
		super(_type, xCoord, yCoord);
		screenToSwitch = _screenToSwitch;
	}
	
	public void setListener() {
		actor.get().addListener(new ClickListener() {
		    public void clicked(InputEvent event, float x, float y) {
		    	
		    	inputPublisher.notifyObservers(screenToSwitch);
		    	
		    	//Remove all current items from game state
		    	dispose();
		    }
		  }
		);
		
	}
	
	@Override
	public void dispose() {
		
		GameState.stage.clear();
		GameState.getGameState().items.clear();
		
	}

}
