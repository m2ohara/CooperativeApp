package com.me.coopapp.ui;

import java.util.ArrayList;
import java.util.Observer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Disposable;
import com.me.coopapp.Types;
import com.me.coopapp.gamestate.GameState;
import com.me.coopapp.gamestate.GdxDisposer;
import com.me.coopapp.gamestate.GdxGameStateItem;
import com.me.coopapp.gamestate.IGLContext;

public class GdxActor implements IGLContext {
	
	protected IGdxActor actor;
	protected float xCentreOffset = 0;
	protected float yCentreOffset = 0;
	protected String type;
	public UIPublisher publisher = new UIPublisher(); 
	protected GdxDisposer itemDisposer = null;
	protected ArrayList<Disposable> gdxItemsToDispose;
	
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
	
	public GdxActor(String _type, float _xCentreOffset, float _yCentreOffset, Types.ScreenTypes screen) {
		type = _type;
		xCentreOffset = _xCentreOffset;
		yCentreOffset = _yCentreOffset;
		
		setGdxGameStateItem(screen);
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
	public void disposeGdx() {
		//Remove instance from stage to improve performance
		actor.get().remove();
		
	}
	
	@Override
	public void setDisposer(GdxDisposer disposer) {
		itemDisposer = disposer;
	}
	
	@Override
	public GdxDisposer getDisposer() {
		return itemDisposer;
	}
	
	private void setGdxGameStateItem() {
		//Add game state item to list for processing
		GameState.get().items.add(new GdxGameStateItem(this));
	}
	
	private void setGdxGameStateItem(Types.ScreenTypes screen) {
		//Add game state item to list for processing
		GameState.get().items.add(new GdxGameStateItem(this));
	}
	
	public void addListener(Observer observer) {
		publisher.addObserver(observer);
	}
	
	public void addListener(ArrayList<Observer> observers) {
		for(Observer observer : observers) {
			publisher.addObserver(observer);
		}
	}

	@Override
	public ArrayList<Disposable> getDisposableGdx() {
		// TODO Auto-generated method stub
		return null;
	}

}
