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
	public ArrayList<GameStateItem> items = new ArrayList<GameStateItem>();
	
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
	
	public void Perform() {
		//Perform current actions
		for(GameStateItem item : items) {
			item.setState();
			
			performGameStateOutcome(item);
		}
		
		
	}
	
	private void performGameStateOutcome(GameStateItem item) {
		
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
	
	private void convertBox2DCoordinates(float x, float y) {

	}

	@Override
	public void Dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getTaskItems() {
		return items;
	}

}
