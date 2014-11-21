package com.me.coopapp.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.me.coopapp.GameLogic;
import com.me.coopapp.ScreenState;
import com.me.coopapp.Types.ScreenTypes;
import com.me.coopapp.gamestate.Disposer;
import com.me.coopapp.gamestate.GameStateItem;
import com.me.coopapp.gamestate.IGLContext;

public class GdxButton extends GdxActor {

	TextureAtlas buttonAtlas;
	Skin skin = new Skin();
	
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
		    	ScreenState.getScreenInstance().type = ScreenTypes.register2Texture;
		    	GameLogic.getInstance().ScreenTasks.add(ScreenState.getScreenInstance());
		    	
		    	//Remove this button
		    	dispose();

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
	public void dispose() {
		
		//Remove from stage
		actor.get().remove();
		buttonAtlas.dispose();
		skin.dispose();
		//Dispose related game item
		itemDisposer.disposeGameStateItem();
		
	}

}
