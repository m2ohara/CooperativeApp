package com.me.coopapp.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.me.coopapp.ScreenState;


public class GdxButton extends GdxActor {

	private TextureAtlas buttonAtlas;
	private Skin skin = new Skin();
	protected Boolean isDefaultListenerOn = true;
	
	
	public GdxButton(String _type) {
		super(_type);
	}
	
	public GdxButton(String _type, float _xCentreOffset, float _yCentreOffset) {
		super(_type, _xCentreOffset, _yCentreOffset);
	}
	
	public GdxButton(String _type, float _xCentreOffset, float _yCentreOffset, ScreenState.Types screen) {
		super(_type, _xCentreOffset, _yCentreOffset, screen);
	}
	
	
	public void instantiate() {
		
		BitmapFont font = new BitmapFont();
		TextButtonStyle style = new TextButtonStyle();
		
		//Set gdx items
		buttonAtlas = new TextureAtlas(Gdx.files.internal("Buttons.pack"));
		skin.addRegions(buttonAtlas);
		style.font = font;
		style.up = skin.getDrawable(type);
		style.down = skin.getDrawable(type+"-down");
		
		//Create button
		actor = new CoopAppButton();
		actor.set(new TextButton("", style));
		
		setListeners();
	}
	
	public void setIsDefaultListener(Boolean isDefaultListener) {
		this.isDefaultListenerOn = isDefaultListener;
	}

	public void setListeners() {
		
		//Added listeners
		if(clickListeners != null) { 
			
			for(ClickListener listener : clickListeners) {
				actor.get().addListener(listener);
			}
			
		}
		
		//Default listeners
		if(isDefaultListenerOn) {
			actor.get().addListener(new ClickListener() {
			    public void clicked(InputEvent event, float x, float y) {
			    	
			    	//Remove this button
			    	itemDisposer.dispose();
	
			    }
			  }
			);
		}
	}
	
	//Nested class
	public class CoopAppButton implements IGdxActor {
		
		private TextButton button;
		
		public CoopAppButton() {
			
		}

		@Override
		public void set(Object _object) {
			button = (TextButton) _object;
		}

		@Override
		public Actor get() {
			return button;
		}
		
	}

}
