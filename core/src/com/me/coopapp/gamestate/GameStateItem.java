package com.me.coopapp.gamestate;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.me.coopapp.Types;
import com.me.coopapp.dispose.Disposer;

public class GameStateItem {
	
	public NextThreadAction state;
	public Types.ScreenTypes screen;
	public Object item;
	public IGLContext glContext;
	protected Disposer itemDisposer = null;
	
	public GameStateItem(Object _item) {
		item = _item;
	}
	
	public enum NextThreadAction {
		GDXINSTANTIATE, GLGSET, GLGACT, DISPOSE, GLGTRANSACTION, GDXDISPOSE
	}
	
	public void setToStage(Stage stage) {
		
	}
	
	//Invoked by GdxDisposer
	public void disposeGSItem() {
		this.state = NextThreadAction.DISPOSE;
//		GameState.get().items.remove(this);
	}

	public Types.ScreenTypes getScreen() {
		return screen;
	}

	public void setScreen(Types.ScreenTypes screen) {
		this.screen = screen;
	}



}
