package com.me.coopapp.gamestate;

public class GdxGameStateItem extends GameStateItem {

	public GdxGameStateItem(Object _item) {
		super(_item);

		glContext = new GLContextItem();
	}
	
	public void initialise() {
		glContext.initialiseItem(item);
	}

}
