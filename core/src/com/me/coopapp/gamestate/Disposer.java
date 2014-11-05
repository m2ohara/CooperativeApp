package com.me.coopapp.gamestate;

import com.me.coopapp.gamestate.GameStateItem.NextThreadAction;

public class Disposer {
	
	private GameStateItem itemToDispose;
	
	public Disposer(GameStateItem item) {
		
		itemToDispose = item;
		
		item.glContext.setDisposer(this);
		
	}
	
	public void dispose() {
		itemToDispose.state = NextThreadAction.Finished;
		itemToDispose.dispose();
	}

}
