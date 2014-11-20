package com.me.coopapp.gamestate;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.me.coopapp.gamestate.GameStateItem.NextThreadAction;

public class GdxGameStateItem extends GameStateItem {

	public GdxGameStateItem(IGLContext _item) {
		super(_item);

		//Set next state to instantiate
		state = GameStateItem.NextThreadAction.GdxInstantiate;
		glContext = _item;
		
		//Set gamestate item to be disposable
		new Disposer(this);
	}
	
	public void instantiateGdxItem() {
		glContext.instantiate();
		state = NextThreadAction.GlgSet;
	}
	
	public void setToStage(Stage stage) {
		glContext.setToStage(stage);
		state = NextThreadAction.GlgAct;
	}


}
