package com.me.coopapp.gamestate;

import com.me.coopapp.gamestate.GameStateItem.NextThreadAction;

public class GdxDisposer {
	
	private GameStateItem itemToDispose;
	
	public GdxDisposer(GameStateItem item) {
		
		itemToDispose = item;
		
		item.glContext.setDisposer(this);
		
	}
	
	public void disposeGameStateItem() {
		itemToDispose.state = NextThreadAction.FINISHED;
		itemToDispose.dispose();
	}

}
