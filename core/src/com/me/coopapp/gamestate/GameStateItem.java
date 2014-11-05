package com.me.coopapp.gamestate;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameStateItem {
	
	public NextThreadAction state;
	public Object item;
	public IGLContext glContext;
	
	public GameStateItem(Object _item) {
		item = _item;
	}
	
	public enum NextThreadAction {
		GdxInstantiate, GlgSet, GlgAct, Finished
	}
	
	public void setToStage(Stage stage) {
		
	}
	
	public void dispose() {
		GameState.getGameState().items.remove(this);
		
	}



}
