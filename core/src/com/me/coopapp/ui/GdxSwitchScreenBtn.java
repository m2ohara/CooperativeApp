package com.me.coopapp.ui;

import java.util.Iterator;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.me.coopapp.GameLogic;
import com.me.coopapp.ITask;
import com.me.coopapp.Types.ScreenTypes;
import com.me.coopapp.gamestate.GameState;
import com.me.coopapp.gamestate.GameStateItem;

public class GdxSwitchScreenBtn extends GdxButton {
	
	public ScreenTypes screenToSwitch;

	public GdxSwitchScreenBtn(String _type, ScreenTypes _screenToSwitch) {
		super(_type);
		screenToSwitch = _screenToSwitch;
	}
	
	public GdxSwitchScreenBtn(String _type, float xCoord, float yCoord, ScreenTypes _screenToSwitch) {
		super(_type, xCoord, yCoord);
		screenToSwitch = _screenToSwitch;
	}
	
	public void setListener() {
		actor.get().addListener(new ClickListener() {
		    public void clicked(InputEvent event, float x, float y) {
		    	
		    	inputPublisher.notifyObservers(screenToSwitch);
		    	
		    	//Remove all current items from game state
		    	disposeGdx();
		    }
		  }
		);
		
	}
	
	@Override
	public void disposeGdx() {
		
		//Dispose all Gdx items on memory
//		Iterator<GameStateItem> it = GameState.get().items.iterator();
//		while(it.hasNext()) {
//			GameStateItem gSItem = it.next();
//			if(gSItem.glContext != null) {
//				gSItem.glContext.disposeGdx();
//			}
//			gSItem.disposeGSItem();
//		}
		
		GameState.get().items.clear();
		GameState.stage.clear();
		
	}

}
