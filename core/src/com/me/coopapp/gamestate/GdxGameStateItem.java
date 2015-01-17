package com.me.coopapp.gamestate;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.me.coopapp.Types;
import com.me.coopapp.dispose.GdxDisposer;

public class GdxGameStateItem extends GameStateItem {

	public GdxGameStateItem(IGLContext _item) {
		super(_item);

		//Set next state to instantiate
		state = GameStateItem.NextThreadAction.GDXINSTANTIATE;
		glContext = _item;
		
		//Set gamestate item to be disposable
		new GdxDisposer(this);
	}
	
	public GdxGameStateItem(IGLContext _item, Types.ScreenTypes _screen) {
		super(_item);

		//Set next state to instantiate
		state = GameStateItem.NextThreadAction.GDXINSTANTIATE;
		glContext = _item;
		
		screen = _screen;
		
		//Set gamestate item to be disposable
		new GdxDisposer(this);
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
