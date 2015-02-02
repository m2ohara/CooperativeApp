package com.me.coopapp.gamestate;

import java.util.HashMap;

import com.me.cooapp.player.Player;
import com.me.cooapp.player.Player.Type;
import com.me.coopapp.ScreenState;
import com.me.coopapp.dispose.Disposer;
import com.me.coopapp.game.GameEngine;

public class GEGameStateItem extends GameStateItem {

	@SuppressWarnings("unchecked")
	public GEGameStateItem(Object players) {
		super(GameEngine.get());
	
		itemDisposer = new Disposer();
		tasksToPerform.put(new Integer(0), new StartGameTask((HashMap<Type, Player>) players));
		tasksToPerform.put(new Integer(1), new PlayRoundTask());
		state = NextThreadAction.YES;
		screen = ScreenState.Types.playGameTexture;
	}

}
