package com.me.coopapp.gamestate;

import com.me.coopapp.GLContextItem;
import com.me.coopapp.screen.Button;

public class GameStateItem {
	
	public WaitingState state;
	Object item;
	public Object stateOutcome;
	
	public GameStateItem(Object _item) {
		item = _item;
	}
	
	public enum WaitingState {
		GdxInstantiate, GlgSet, GlgAct
	}
	
	public void setState() {
		if(state == WaitingState.GdxInstantiate) {
			stateOutcome = new GLContextItem(item);
		}
		
		if(state == WaitingState.GlgSet) {
			stateOutcome = ((Button)item).instance;
		}
	}



}
