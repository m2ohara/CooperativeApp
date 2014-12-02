package com.me.coopapp.ui;

import java.util.ArrayList;
import java.util.Observer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.me.coopapp.gamestate.Disposer;
import com.me.coopapp.gamestate.GameState;
import com.me.coopapp.gamestate.GdxGameStateItem;
import com.me.coopapp.gamestate.IGLContext;

public class GdxActor implements IGLContext {
	
	protected IGdxActor actor;
	protected float xCentreOffset = 0;
	protected float yCentreOffset = 0;
	protected String type;
	public UIPublisher inputPublisher = new UIPublisher(); 
	
	protected Disposer itemDisposer = null;
	
	public GdxActor() {
		setGdxGameStateItem();
	}
	
	public GdxActor(String _type) {
		type = _type;
		
		setGdxGameStateItem();
	}
	
	public GdxActor(float _xCentreOffset, float _yCentreOffset) {
		xCentreOffset = _xCentreOffset;
		yCentreOffset = _yCentreOffset;
		
		setGdxGameStateItem();
	}
	
	public GdxActor(String _type, float _xCentreOffset, float _yCentreOffset) {
		type = _type;
		xCentreOffset = _xCentreOffset;
		yCentreOffset = _yCentreOffset;
		
		setGdxGameStateItem();
	}
	
	protected void setWidth() {
		//TO DO: Pass param values
		actor.get().setWidth(202);
	}
	
	protected void setHeight() {
		actor.get().setHeight(76);
	}
	
	public void setToStage(Stage stage) {
		
		setRelativePosition(actor.get());
		//Add actor to stage for physics processing
		stage.addActor(actor.get());
	}
	
	protected void setRelativePosition(Actor actorToSet) {
		
		//Centre actor
		float x = (Gdx.graphics.getWidth() - actorToSet.getWidth()) /2 ;
		float y = (Gdx.graphics.getHeight()  - actorToSet.getHeight()) / 2;
		
		x += xCentreOffset;
		y += yCentreOffset;
		
		actorToSet.setPosition(x, y);
	}

	@Override
	public void instantiate() {
		// Inherited method for creating instance while in Gdx thread
		
	}

	@Override
	public void dispose() {
		//Remove instance from stage to improve performance
		actor.get().remove();
		
	}
	
	@Override
	public void setDisposer(Disposer disposer) {
		itemDisposer = disposer;
	}
	
	private void setGdxGameStateItem() {
		//Add game state item to list for processing
		GameState.getGameState().items.add(new GdxGameStateItem(this));
	}
	
	public void addListener(Observer observer) {
		inputPublisher.addObserver(observer);
	}
	
	public void addListener(ArrayList<Observer> observers) {
		for(Observer observer : observers) {
			inputPublisher.addObserver(observer);
		}
	}

}
