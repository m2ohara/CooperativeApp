package com.me.coopapp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameState implements ITask {
	
	public static Stage stage;
	public static Actor actor;
	private static GameState gameInstance;
	
	//Singleton
	private GameState() {
		stage = new Stage();
	}
	
	public static GameState getGameState() {
		if(gameInstance == null) {
			gameInstance = new GameState();
		}
		return gameInstance;
	}
	
	public void Perform() {
		stage.act(Gdx.graphics.getDeltaTime());
	}
	
	public void SetActors(Actor actorToAdd) {
		stage.addActor(actorToAdd);
	}

	@Override
	public void Dispose() {
		// TODO Auto-generated method stub
		
	}

}
