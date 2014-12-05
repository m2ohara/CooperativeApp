package com.me.coopapp.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.me.coopapp.Types;
import com.me.coopapp.Types.ScreenTypes;
import com.me.coopapp.gamestate.GameState;

public class GdxSwitchScreenBtn extends GdxButton {
	
	public ScreenTypes screenToSwitch;

	public GdxSwitchScreenBtn(String _type, ScreenTypes _screenToSwitch) {
		super(_type);
		
		//Set screen to switch to
		screenToSwitch = _screenToSwitch;
		
		//Add listener for screen switching action
		addListener(new ListenerSwitchScreen());
	}
	
	public GdxSwitchScreenBtn(String _type, float xCoord, float yCoord, ScreenTypes _screenToSwitch) {
		super(_type, xCoord, yCoord);

		//Set screen to switch to
		screenToSwitch = _screenToSwitch;
		
		//Add listener for screen switching action
		addListener(new ListenerSwitchScreen());
	}
	
	public GdxSwitchScreenBtn(String _type, float xCoord, float yCoord, ScreenTypes _screenToSwitch, Types.ScreenTypes screen) {
		super(_type, xCoord, yCoord, screen);

		//Set screen to switch to
		screenToSwitch = _screenToSwitch;
		
		//Add listener for screen switching action
		addListener(new ListenerSwitchScreen());
	}
	
	public void setListener() {
		actor.get().addListener(new ClickListener() {
		    public void clicked(InputEvent event, float x, float y) {
		    	
		    	//Remove all current items from game state
		    	itemDisposer.disposeAll();
		    	
		    	publisher.notifyObservers(screenToSwitch);
		    }
		  }
		);
		
	}
	
	@Override
	public void disposeGdx() {
		
		//TO DO: Remove specified actors / items
		GameState.get().items.clear();
		GameState.stage.clear();
		
	}

}
