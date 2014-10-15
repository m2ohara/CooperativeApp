package com.me.coopapp.gamestate;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.me.coopapp.ITask;
import com.me.coopapp.gamestate.GameStateItem.NextState;

public class GameState implements ITask {
	
	public static Stage stage = new Stage();
	public static Actor actor;
	private static GameState gameInstance;
	public static ArrayList<GameStateItem> items = new ArrayList<GameStateItem>();
	public static ArrayList<Object> gdxItems = new ArrayList<Object>();
	
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
	
	public void Perform(boolean isGdxThread) {
		//Perform current actions
		for(GameStateItem item : items) {
			
//			setGdxState();
			
			item.setState();
			
			//Perform logic within game logic thread
			if(!isGdxThread)
				performGlgOutcome(item);
			
			//Perform logic within Gdx thread
			if(isGdxThread)
				performGdxOutcome(item);
		}
		
		
	}
	
	@SuppressWarnings("unchecked")
//	public void setGdxState() {
//		//Check task outcome
////		ArrayList<GameStateItem> GameItems = (ArrayList<GameStateItem>)this.getTaskItems();
//		for(GameStateItem item : items) {
//			//If item needs to be instantiated in GL context
//			if(item.state == NextState.GdxInstantiate && item.stateOutcome != null) {
//				gdxItems.add(item.stateOutcome);
//				item.state = NextState.GlgSet;
//			}
//		}
//	}
	
	//Called from Gdx thread
//	public static void performGdxProcess() {
//		
//		if(!items.isEmpty()) {
//			for(Object item : gdxItems) {
//				
//				//Initialise any items needing GL context
//				if(item instanceof GameStateItem) {
//					((GdxGameStateItem) item).initialise();
//				}
//				
//				//Set items needed to render
//				if(item instanceof Actor) {
//				}
//			}
//			
//			gdxItems.clear();
//		}
//	}
	
	private void performGdxOutcome(GameStateItem item) {
		//Initialise any items needing GL context
		if(item instanceof GdxGameStateItem && item.state == NextState.GdxInstantiate) {
			((GdxGameStateItem) item).initialise();
		}
		
		//Set items needed to render
//		if(item instanceof Actor) {
//		}
	}
	
	private void performGlgOutcome(GameStateItem item) {
		
		if(item.state == NextState.GlgSet && item.stateOutcome != null) {
			try {
				if(item.stateOutcome.getClass() == Class.forName("com.badlogic.gdx.scenes.scene2d.ui.TextButton")) {
					SetActor(item);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			item.state = NextState.GlgAct;
		}
	}

	@Override
	public void Dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getTaskItems() {
		return items;
	}
	
	public void SetActor(GameStateItem gState) {
		
		setRelativePosition((Actor) gState.stateOutcome);
		stage.addActor((Actor) gState.stateOutcome);
	}
	
	
	//TODO: Refactor into object specific class
	private void setRelativePosition(Actor actorToSet) {
		
		//Set texture position based on screen size 
		float x = (Gdx.graphics.getWidth() - actorToSet.getWidth()) /2 ;
		float y = (Gdx.graphics.getHeight()  - actorToSet.getHeight()) / 2;
		
		actorToSet.setPosition(x, y);
	}

}
