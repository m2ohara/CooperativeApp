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
		GDXINSTANTIATE, GLGSET, GLGACT, FINISHED, GLGTRANSACTION
	}
	
	public void setToStage(Stage stage) {
		
	}
	
	public void dispose() {
		GameState.get().items.remove(this);
		
	}



}
