package com.me.coopapp.gamestate;

import java.util.ArrayList;

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
	
	public static GameState getGameState() {
		if(gameInstance == null) {
			gameInstance = new GameState();
		}
		return gameInstance;
	}
	
	public void perform(boolean isGdxThread) {
		isTaskComplete = true;
		
		ArrayList<GameStateItem> complete = new ArrayList<GameStateItem>();
		//Perform current actions
		for(GameStateItem item : items) {
			
			//Perform logic within game logic thread
			if(!isGdxThread)
				performGlgAction(item);
			
			//Perform logic within Gdx thread
			if(isGdxThread)
				performGdxAction(item);
			
			//Check if item action is not complete
			if(item.state != GameStateItem.NextThreadAction.Finished) {
				isTaskComplete = false;
			}
			else {
				complete.add(item);
			}
		}
		
//		items.removeAll(complete);
		
	}
	
	private void performGdxAction(GameStateItem item) {
		
		//Initialise any items needing GL context
		if(item instanceof GdxGameStateItem && item.state == NextThreadAction.GdxInstantiate) {
			((GdxGameStateItem) item).instantiateGdxItem();
		}
	}
	
	private void performGlgAction(GameStateItem item) {

		if(item instanceof GameStateItem && item.state == NextThreadAction.GlgSet) {
			((GdxGameStateItem) item).setToStage(stage);
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
