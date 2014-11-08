package com.me.coopapp.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.me.coopapp.gamestate.Disposer;
import com.me.coopapp.gamestate.IGLContext;

public class CoopAppActor implements IGLContext {
	
	protected ICoopAppActor actor;
	protected float xCentreOffset = 0;
	protected float yCentreOffset = 0;
	protected String type;
	
	public CoopAppActor(String _type) {
		type = _type;
	}
	
	public CoopAppActor(String _type, float _xCentreOffset, float _yCentreOffset) {
		type = _type;
		xCentreOffset = _xCentreOffset;
		yCentreOffset = _yCentreOffset;
	}
	
	protected void setWidth() {
		actor.get().setWidth(202);
	}
	
	protected void setHeight() {
		actor.get().setHeight(76);
	}
	
	public void setToStage(Stage stage) {
		
		setRelativePosition(actor.get());
		stage.addActor(actor.get());
	}
	
	protected void setRelativePosition(Actor actorToSet) {
		
		//Centre button
		float x = (Gdx.graphics.getWidth() - actorToSet.getWidth()) /2 ;
		float y = (Gdx.graphics.getHeight()  - actorToSet.getHeight()) / 2;
		
		x += xCentreOffset;
		y += yCentreOffset;
		
		actorToSet.setPosition(x, y);
	}

	@Override
	public void setDisposer(Disposer disposer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void instantiate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
