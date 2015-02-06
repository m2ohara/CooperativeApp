package com.me.coopapp.gamestate;


import com.badlogic.gdx.scenes.scene2d.Stage;
import com.me.coopapp.ScreenState;
import com.me.coopapp.dispose.Disposer;

public class GameStateItem {
	
	public NextThreadAction state;
	public ScreenState.Types screen;
	public Object item;
	public IGLContext glContext;
	protected Disposer itemDisposer = null;
	
	public GameStateItem(Object _item) {
		item = _item;
	}
	
	public enum NextThreadAction {
		GDXINSTANTIATE, GLGSET, GLGACT, DISPOSE, GLGTRANSACTION, GDXDISPOSE, YES, NO
	}
	
	public void setToStage(Stage stage) {
		
	}
	
	//Invoked by GdxDisposer
	public void disposeGSItem() {
		this.state = NextThreadAction.DISPOSE;
	}

	public ScreenState.Types getScreen() {
		return screen;
	}

	public void setScreen(ScreenState.Types screen) {
		this.screen = screen;
	}



}
