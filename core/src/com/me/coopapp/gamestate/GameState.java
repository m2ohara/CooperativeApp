package com.me.coopapp.gamestate;

import java.util.concurrent.ConcurrentHashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.me.coopapp.ITask;
import com.me.coopapp.gamestate.GameStateItem.NextThreadAction;

public class GameState implements ITask {
	
	public static Stage stage = new Stage();
	private static GameState gameInstance;
	public ConcurrentHashMap<Integer, GameStateItem> items = new ConcurrentHashMap<Integer, GameStateItem>();
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
		for(GameStateItem item : items.values()) {
			
			//If finished remove (Refactor to dispose method)
			if(item.state == GameStateItem.NextThreadAction.DISPOSE) {
				items.remove(item.hashCode());
			}
			
			//Perform logic within game logic thread
			else if(!isGdxThread)
				performGlgAction(item);
			
			//Perform logic within Gdx thread
			else if(isGdxThread)
				performGdxAction(item);
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
		
		if(item instanceof GameStateItem && item.state == NextThreadAction.YES) {
			//Perform next task
			item.performTask();
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
	
	public void addTask(GameStateItem task) {
		GameState.get().items.put(task.hashCode(), task);
	}

}
