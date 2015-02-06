package com.me.coopapp.ui;

import java.util.HashMap;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.me.coopapp.ScreenState;
import com.me.coopapp.gamestate.GameState;

public class GdxSwitchScreenBtn extends GdxButton {
	
	public ScreenState.Types screenToSwitch;

	public GdxSwitchScreenBtn(String _type, ScreenState.Types _screenToSwitch) {
		super(_type);
		
		//Set screen to switch to
		screenToSwitch = _screenToSwitch;
		
		//Add listener for screen switching action
		addListener(new ListenerSwitchScreen());
	}
	
	public GdxSwitchScreenBtn(String _type, float xCoord, float yCoord, ScreenState.Types _screenToSwitch) {
		super(_type, xCoord, yCoord, _screenToSwitch);

		//Set screen to switch to
		screenToSwitch = _screenToSwitch;
		
		//Add listener for screen switching action
		addListener(new ListenerSwitchScreen());
	}
	
	public GdxSwitchScreenBtn(String _type, float xCoord, float yCoord, ScreenState.Types _screenToSwitch, ScreenState.Types screen) {
		super(_type, xCoord, yCoord, screen);

		//Set screen to switch to
		screenToSwitch = _screenToSwitch;
		
		//Add listener for screen switching action
		addListener(new ListenerSwitchScreen());
	}
	
	public void setListener() {
		
		//Other click triggers
		if(clickListener != null) { actor.get().addListener(clickListener);}
		
		//Default click triggers
		actor.get().addListener(new ClickListener() {
		    public void clicked(InputEvent event, float x, float y) {
		    	
		    	//Remove all current items from game state
		    	itemDisposer.disposeAll();
		    	
		    	HashMap<UIPublisher.ParameterType, Object> parameters = new HashMap<UIPublisher.ParameterType, Object>();
		    	parameters.put(UIPublisher.ParameterType.SCREEN, screenToSwitch);
		    	
		    	publisher.notifyObservers(parameters);
		    }
		  }
		);
	
		
	}
	
	@Override
	public void disposeGdx() {
		
		//TO DO: Remove specified actors / items
//		GameState.get().items.clear();
//		GameState.stage.clear();
		
	}

}
