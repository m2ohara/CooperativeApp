package com.me.coopapp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.me.coopapp.screen.Button;

public class GameState implements ITask {
	
	public static Stage stage = new Stage();
	public static Actor actor;
	private static GameState gameInstance;
	
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
		SetActors(new Button("").button );
	}
	
	public void SetActors(Actor actorToAdd) {
		
		setRelativePosition(actorToAdd);
		stage.addActor(actorToAdd);
	}
	
	private void setRelativePosition(Actor actorToSet) {
		
		//Set texture position based on screen size 
		float x = (Gdx.graphics.getWidth() - actorToSet.getWidth()) /2 ;
		float y = (Gdx.graphics.getHeight()  - actorToSet.getHeight()) / 2;
		
		actorToSet.setPosition(20, 20);
	}
	
	private void convertBox2DCoordinates(float x, float y) {

	}

	@Override
	public void Dispose() {
		// TODO Auto-generated method stub
		
	}

}
