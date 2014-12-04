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
import com.me.coopapp.Types.ScreenTypes;


public class GdxButton extends GdxActor {

	private TextureAtlas buttonAtlas;
	private Skin skin = new Skin();
	
	
	public GdxButton(String _type) {
		super(_type);
	}
	
	public GdxButton(String _type, float _xCentreOffset, float _yCentreOffset) {
		super(_type, _xCentreOffset, _yCentreOffset);
	}
	
	public void instantiate() {
		
		BitmapFont font = new BitmapFont();
		TextButtonStyle style = new TextButtonStyle();
		
		buttonAtlas = new TextureAtlas(Gdx.files.internal("Buttons.pack"));
		skin.addRegions(buttonAtlas);
		style.font = font;
		style.up = skin.getDrawable(type);
		style.down = skin.getDrawable(type+"-down");
		
		actor = new CoopAppButton();
		actor.set(new TextButton("", style));
		
		
		setListener();
	}
	
	public void setListener() {
		actor.get().addListener(new ClickListener() {
		    public void clicked(InputEvent event, float x, float y) {
		        //Change screen
		    	ScreenState.getScreenInstance().setTask(ScreenTypes.register2Texture);
		    	
//		    	//Remove this button
//		    	dispose();
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
	public void disposeGdx() {
		
		//Remove from stage
		actor.get().remove();
		
		//Remove gdx items
		buttonAtlas.dispose();
		skin.dispose();
		
	}

}
