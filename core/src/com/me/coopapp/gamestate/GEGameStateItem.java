package com.me.coopapp.gamestate;


import com.me.coopapp.ScreenState;
import com.me.coopapp.game.GameEngine;

public class GEGameStateItem extends GameStateItem {

	public GEGameStateItem(Object players) {
		super(GameEngine.get());
	
//		itemDisposer = new Disposer(this);
//		tasksToPerform.put(new Integer(0), new StartGameTask((HashMap<Type, Player>) players));
//		tasksToPerform.put(new Integer(1), new PlayRoundTask());
		state = NextThreadAction.YES;
		screen = ScreenState.Types.playGameTexture;
	}

}
