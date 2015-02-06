package com.me.coopapp.ui;

import java.util.ArrayList;
import java.util.Observer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Disposable;
import com.me.coopapp.ScreenState;
import com.me.coopapp.dispose.Disposer;
import com.me.coopapp.gamestate.GameState;
import com.me.coopapp.gamestate.GdxGameStateItem;
import com.me.coopapp.gamestate.IGLContext;

public class GdxActor implements IGLContext {
	
	protected IGdxActor actor;
	protected float xCentreOffset = 0;
	protected float yCentreOffset = 0;
	protected String type;
	public UIPublisher publisher = new UIPublisher(); 
	protected Disposer itemDisposer = null;
	protected ArrayList<Disposable> gdxItemsToDispose;
	protected ClickListener clickListener;

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
	
	public GdxActor(float _xCentreOffset, float _yCentreOffset, ScreenState.Types screen) {
		xCentreOffset = _xCentreOffset;
		yCentreOffset = _yCentreOffset;
		
		setGdxGameStateItem(screen);
	}
	
	public GdxActor(String _type, float _xCentreOffset, float _yCentreOffset) {
		type = _type;
		xCentreOffset = _xCentreOffset;
		yCentreOffset = _yCentreOffset;
		
		setGdxGameStateItem();
	}
	
	public GdxActor(String _type, float _xCentreOffset, float _yCentreOffset, ScreenState.Types screen) {
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
	
	private void setGdxGameStateItem() {
		//Add game state item to list for processing
		GdxGameStateItem item = new GdxGameStateItem(this);
		itemDisposer = item.getItemDisposer();
		GameState.get().items.put(item.hashCode(), item);
	}
	
	private void setGdxGameStateItem(ScreenState.Types screen) {
		//Add game state item to list for processing
		GdxGameStateItem item = new GdxGameStateItem(this, screen);
		itemDisposer = item.getItemDisposer();
		GameState.get().items.put(item.hashCode(), item);
	}
	
	public void addListener(Observer observer) {
		publisher.addObserver(observer);
	}
	
	public void setListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}
	
	public void addListener(ArrayList<Observer> observers) {
		for(Observer observer : observers) {
			publisher.addObserver(observer);
		}
	}
	
	public enum Type {}

	@Override
	public IGdxActor getIGdxActor() {
		// TODO Auto-generated method stub
		return actor;
	}

}
