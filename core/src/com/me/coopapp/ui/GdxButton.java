package com.me.coopapp.ui;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Disposable;
import com.me.coopapp.ScreenState;


public class GdxButton extends GdxActor {

	private TextureAtlas buttonAtlas;
	private Skin skin = new Skin();
	
	
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
		
		setListener();
	}
	
	public void setListener() {
		actor.get().addListener(new ClickListener() {
		    public void clicked(InputEvent event, float x, float y) {

		    	publisher.notifyObservers();
		    	
		    	//Remove this button
		    	itemDisposer.dispose();

		    }
		  }
		);
	}
	
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

	@Override
	//Invoked by GdxDisposer
	public void disposeGdx() {
		
		//Remove from stage
		actor.get().remove();
		
		//Remove gdx items
		buttonAtlas.dispose();
		skin.dispose();
		
	}
	
	//Invoked during runtime (after gdx instantiation)
	public ArrayList<Disposable> getDisposableGdx() {
		gdxItemsToDispose = new ArrayList<Disposable>();
		gdxItemsToDispose.add(buttonAtlas);
		gdxItemsToDispose.add(skin);
		return gdxItemsToDispose;
	}

}
