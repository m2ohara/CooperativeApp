package com.me.coopapp.gamestate;

import com.me.coopapp.screen.Button;

public class GameStateItem {
	
	public NextState state;
	Object item;
	public Object stateOutcome;
	public IGLContext glContext;
	
	public GameStateItem(Object _item) {
		item = _item;
	}
	
	public enum NextState {
		GdxInstantiate, GlgSet, GlgAct
	}
	
	public void setState() {
		if(state == NextState.GdxInstantiate) {
			stateOutcome = new GLContextItem();
		}
		
		if(state == NextState.GlgSet) {
			stateOutcome = ((Button)item).instance;
		}
	}



}
