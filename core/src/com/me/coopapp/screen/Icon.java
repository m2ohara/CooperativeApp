package com.me.coopapp.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.ObjectSet;

public class Icon extends CoopAppActor{
	
	public Icon(String _type) {
		super(_type);
	}
	
	public Icon(String _type, float _xCentreOffset, float _yCentreOffset) {
		super(_type, _xCentreOffset, _yCentreOffset);
	}

	@Override
	public void instantiate() {
		actor = new CoopAppIcon();
		
		actor.set(new Image(getDrawableFromPack("Buttons")));
		
	}
	
	private Drawable getDrawableFromPack(String packName) {

		TextureAtlas txAtlas = new TextureAtlas(Gdx.files.internal(""+packName+".pack"));
		Skin txSkin = new Skin(txAtlas);

		return txSkin.getDrawable(type);
	}

}
