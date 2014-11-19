package com.me.coopapp.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;


public class GdxTextField extends CoopAppActor {
	
	public GdxTextField(float _xCentreOffset, float _yCentreOffset) {
		super(_xCentreOffset, _yCentreOffset);
	}
	
	public void instantiate() {
		actor = new CoopAppTextField();
		
		actor.set(new TextField("TO DO: Set with style name?", getSkinFromPack("Buttons")));
	}
	
	//TO DO: Implement disposer
	
	private Skin getSkinFromPack(String packName) {

		TextureAtlas txAtlas = new TextureAtlas(Gdx.files.internal(""+packName+".pack"));

		return new Skin(txAtlas);
	}
	
	public class CoopAppTextField implements ICoopAppActor {
		
		Image textField;
		
		public CoopAppTextField() {
			
		}

		@Override
		public void set(Object _object) {
			textField = (Image) _object;
			
		}

		@Override
		public Actor get() {
			return textField;
		}

	}

}
