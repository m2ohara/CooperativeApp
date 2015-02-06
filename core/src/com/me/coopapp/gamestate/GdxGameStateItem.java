package com.me.coopapp.gamestate;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.me.coopapp.ScreenState;

public class GdxGameStateItem extends GameStateItem {

	public GdxGameStateItem(IGLContext _item) {
		super(_item);

		//Set next state to instantiate
		state = GameStateItem.NextThreadAction.GDXINSTANTIATE;
		glContext = _item;
		

	}
	
	public GdxGameStateItem(IGLContext _item, ScreenState.Types _screen) {
		super(_item);

		//Set next state to instantiate
		state = GameStateItem.NextThreadAction.GDXINSTANTIATE;
		glContext = _item;
		
		screen = _screen;
		
	}
	
	public void instantiateGdxItem() {
		glContext.instantiate();
		state = NextThreadAction.GLGSET;
	}
	
	public void setToStage(Stage stage) {
		glContext.setToStage(stage);
		state = NextThreadAction.GLGACT;
	}


}
