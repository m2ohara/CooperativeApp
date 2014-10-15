package com.me.coopapp.gamestate;

public class GdxGameStateItem extends GameStateItem {

	public GdxGameStateItem(Object _item) {
		super(_item);

		glContext = new GLContextItem();
	}
	
	public void initialise() {
		stateOutcome = new GLContextItem();
		glContext.initialiseItem(item);
		state = NextState.GlgSet;
	}

}
