package com.me.coopapp.screen;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.me.coopapp.GameLogic;
import com.me.coopapp.ScreenState;
import com.me.coopapp.Types.ScreenTypes;

public class ScreenSwitchButton extends Button {
	
	public ScreenTypes screenToSwitch;

	public ScreenSwitchButton(String _type, ScreenTypes _screenToSwitch) {
		super(_type);
		screenToSwitch = _screenToSwitch;
	}
	
	public ScreenSwitchButton(String _type, float xCoord, float yCoord, ScreenTypes _screenToSwitch) {
		super(_type, xCoord, yCoord);
		screenToSwitch = _screenToSwitch;
	}
	
	public void SetListener() {
		instance.addListener(new ClickListener() {
		    public void clicked(InputEvent event, float x, float y) {
		    	//Set screen to switch to on click
		    	ScreenState.getScreenInstance().type = screenToSwitch;
		    	GameLogic.getInstance().ScreenTasks.add(ScreenState.getScreenInstance());
		    	
		    	//Remove this button
		    	dispose();
		    	
		    }
		  }
		);
	}

}
