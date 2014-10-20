package com.me.coopapp.screen;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.me.coopapp.GameLogic;
import com.me.coopapp.ScreenState;
import com.me.coopapp.Types.ScreenTypes;

public class ScreenSwitchButton extends Button {

	public ScreenSwitchButton(String _type) {
		super(_type);
		// TODO Auto-generated constructor stub
	}
	
	public ScreenSwitchButton(String _type, float xCoord, float yCoord) {
		super(_type, xCoord, yCoord);
		// TODO Auto-generated constructor stub
	}
	
	public void SetListener(final ScreenTypes screenToSwitch) {
		instance.addListener(new ClickListener() {
		    public void clicked(InputEvent event, float x, float y) {
		    	ScreenState.getScreenInstance().type = screenToSwitch;
		    	GameLogic.getInstance().ScreenTasks.add(ScreenState.getScreenInstance());
		    }
		  }
		);
	}

}
