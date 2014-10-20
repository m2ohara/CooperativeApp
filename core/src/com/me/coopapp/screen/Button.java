package com.me.coopapp.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.me.coopapp.GameLogic;
import com.me.coopapp.ScreenState;
import com.me.coopapp.Types;
import com.me.coopapp.Types.ScreenTypes;
import com.me.coopapp.gamestate.IGLContext;

public class Button implements IGLContext {

	protected TextButton instance;
	
	private String type;
	private TextureAtlas buttonAtlas;
	private BitmapFont font = new BitmapFont();
	private Skin skin = new Skin();
	private TextButtonStyle style = new TextButtonStyle();
	private float xCentreOffset = 0;
	private float yCentreOffset = 0;
	
	public Button(String _type) {
		type = _type;
	}
	
	public Button(String _type, float _xCentreOffset, float _yCentreOffset) {
		type = _type;
		xCentreOffset = _xCentreOffset;
		yCentreOffset = _yCentreOffset;
	}
	
	public void instantiate() {
		
		//Set Gdx button. Only perform in Gdx thread
		//TODO: Add check for correct thread
		buttonAtlas = new TextureAtlas(Gdx.files.internal("Buttons.pack"));
		skin.addRegions(buttonAtlas);
		style.font = font;
		style.up = skin.getDrawable(type);
		style.down = skin.getDrawable(type+"-down");
		instance = new TextButton("", style);
		
		setWidth();
		setHeight();
		
		setListener(ScreenTypes.startTexture);
	}
	
	public void setListener(final ScreenTypes type) {
		instance.addListener(new ClickListener() {
		    public void clicked(InputEvent event, float x, float y) {
		        //Change screen
		    	ScreenState.getScreenInstance().type = type;
		    	GameLogic.getInstance().ScreenTasks.add(ScreenState.getScreenInstance());	    		

		    }
		  }
		);
	}
	
	private void setWidth() {
		instance.setWidth(202);
	}
	
	private void setHeight() {
		instance.setHeight(76);
	}
	
	public void setToStage(Stage stage) {
		
		setRelativePosition((Actor) instance);
		stage.addActor((Actor) instance);
	}
	
	private void setRelativePosition(Actor actorToSet) {
		
		//Centre button
		float x = (Gdx.graphics.getWidth() - actorToSet.getWidth()) /2 ;
		float y = (Gdx.graphics.getHeight()  - actorToSet.getHeight()) / 2;
		
		x += xCentreOffset;
		y += yCentreOffset;
		
		actorToSet.setPosition(x, y);
	}
	
	public void dispose() {
		
	}

}
