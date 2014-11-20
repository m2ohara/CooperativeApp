package com.me.coopapp.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;


public class GdxTextField extends GdxActor {
	
	public GdxTextField(float _xCentreOffset, float _yCentreOffset) {
		super(_xCentreOffset, _yCentreOffset);
	}
	
	public void instantiate() {
		actor = new CoopAppTextField();
		
		actor.set(new TextField("", new Skin(Gdx.files.internal("Data/uiskin.json"))));
	}
	
	
	public class CoopAppTextField implements IGdxActor {
		
		TextField textField;
		
		public CoopAppTextField() {
			
		}

		@Override
		public void set(Object _object) {
			textField = (TextField) _object;
			
		}

		@Override
		public Actor get() {
			return textField;
		}

	}

}
