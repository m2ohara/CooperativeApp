package com.me.coopapp.gamestate;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.me.coopapp.ScreenState;
import com.me.coopapp.dispose.Disposer;

public class GameStateItem {
	
	public NextThreadAction state;
	public ScreenState.Types screen;
	public Object item;
	public IGLContext glContext;
	protected Disposer itemDisposer = null;
	public ConcurrentHashMap<Integer, IGLGPerform> tasksToPerform;
	
	public GameStateItem(Object _item) {
		item = _item;
		tasksToPerform = new ConcurrentHashMap<Integer, IGLGPerform>();
	}
	
	public enum NextThreadAction {
		GDXINSTANTIATE, GLGSET, GLGACT, DISPOSE, GLGTRANSACTION, GDXDISPOSE, YES, NO
	}
	
	public void setToStage(Stage stage) {
		
	}
	
	public void performTask() {
		if(tasksToPerform.size() != 0) {
			
			IGLGPerform task = tasksToPerform.elements().nextElement();
			
			//If next task is to be performed
			if(task.getIsNextAction() == NextThreadAction.YES) {
				//Perform
				task.perform("");
				//Set following action to perform next
				tasksToPerform.elements().nextElement().setIsNextAction(NextThreadAction.YES);
				//Remove performed action
				tasksToPerform.remove(task);
			}
		}
		
//		disposeGSItem();
		
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
