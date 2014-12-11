package com.me.coopapp.gamestate;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.me.coopapp.ITask;
import com.me.coopapp.gamestate.GameStateItem.NextThreadAction;

public class GameState implements ITask {
	
	public static Stage stage = new Stage();
	private static GameState gameInstance;
	public ArrayList<GameStateItem> items = new ArrayList<GameStateItem>();
	public boolean isTaskComplete = false;
	
	//Singleton
	private GameState() {
		Gdx.input.setInputProcessor(stage);
	}
	
	public static GameState get() {
		if(gameInstance == null) {
			gameInstance = new GameState();
		}
		return gameInstance;
	}
	
	public synchronized void perform(boolean isGdxThread) {
		isTaskComplete = true;
		
		//Perform current actions
		Iterator<GameStateItem> it = items.iterator();
		while(it.hasNext()) {
			
			GameStateItem itemToPerform = it.next();
			
			//If finished remove
			if(itemToPerform.state == GameStateItem.NextThreadAction.DISPOSE) {
				it.remove();
				break;
			}
			
			//Perform logic within game logic thread
			if(!isGdxThread)
				performGlgAction(itemToPerform);
			
			//Perform logic within Gdx thread
			if(isGdxThread)
				performGdxAction(itemToPerform);
		}
		
	}
	
	private void performGdxAction(GameStateItem item) {
		
		//Initialise any items needing GL context
		if(item instanceof GdxGameStateItem && item.state == NextThreadAction.GDXINSTANTIATE) {
			((GdxGameStateItem) item).instantiateGdxItem();
		}
	}
	
	private void performGlgAction(GameStateItem item) {

		if(item instanceof GameStateItem && item.state == NextThreadAction.GLGSET) {
			((GdxGameStateItem) item).setToStage(stage);
		}
		if(item instanceof GameStateItem && item.state == NextThreadAction.GLGTRANSACTION) {
			((DbGameStateItem) item).performDbTransaction();
		}
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isTaskComplete() {
		return isTaskComplete;
	}

}
