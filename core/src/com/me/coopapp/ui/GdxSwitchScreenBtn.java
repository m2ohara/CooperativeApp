package com.me.coopapp.ui;

import java.util.HashMap;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.me.coopapp.ScreenState;

public class GdxSwitchScreenBtn extends GdxButton {
	
	public ScreenState.Types screenToSwitch;

	public GdxSwitchScreenBtn(String _type, ScreenState.Types _screenToSwitch) {
		super(_type);
		
		//Set screen to switch to
		screenToSwitch = _screenToSwitch;
		
		//Add listener for screen switching action
		addObserver(new ObserverSwitchScreen());
	}
	
	public GdxSwitchScreenBtn(String _type, float xCoord, float yCoord, ScreenState.Types _screenToSwitch) {
		super(_type, xCoord, yCoord, _screenToSwitch);

		//Set screen to switch to
		screenToSwitch = _screenToSwitch;
		
		//Add listener for screen switching action
		addObserver(new ObserverSwitchScreen());
	}
	
	public GdxSwitchScreenBtn(String _type, float xCoord, float yCoord, ScreenState.Types _screenToSwitch, ScreenState.Types screen) {
		super(_type, xCoord, yCoord, screen);

		//Set screen to switch to
		screenToSwitch = _screenToSwitch;
		
		//Add listener for screen switching action
		addObserver(new ObserverSwitchScreen());
	}
	
	public void setListeners() {
		
		//Other click triggers
		if(clickListeners != null) { 
			for(ClickListener listener : clickListeners) {
				actor.get().addListener(listener);
			}
		}
		
		//Default click triggers
		if(isDefaultListenerOn) {
			actor.get().addListener(new ClickListener() {
			    public void clicked(InputEvent event, float x, float y) {
			    	
			    	//Remove all current items from game state
			    	itemDisposer.disposeGroup();
			    	
			    	HashMap<UIPublisher.ParameterType, Object> parameters = new HashMap<UIPublisher.ParameterType, Object>();
			    	parameters.put(UIPublisher.ParameterType.SCREEN, screenToSwitch);
			    	
			    	publisher.notifyObservers(parameters);
			    }
			  }
			);
		}
	
		
	}


}
