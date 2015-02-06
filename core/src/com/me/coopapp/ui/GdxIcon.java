package com.me.coopapp.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.me.coopapp.ScreenState;

public class GdxIcon extends GdxActor{
	
	private TextureAtlas txAtlas;
	private Skin txSkin;
	
	public GdxIcon(String _type) {
		super(_type);
	}
	
	public GdxIcon(String _type, float _xCentreOffset, float _yCentreOffset) {
		super(_type, _xCentreOffset, _yCentreOffset);
	}
	
	public GdxIcon(String _type, float _xCentreOffset, float _yCentreOffset, ScreenState.Types screen) {
		super(_type, _xCentreOffset, _yCentreOffset, screen);
	}

	@Override
	public void instantiate() {
		actor = new CoopAppIcon();
		
		actor.set(new Image(getDrawableFromPack("Icons")));
		
	}
	
	private Drawable getDrawableFromPack(String packName) {

		txAtlas = new TextureAtlas(Gdx.files.internal(""+packName+".pack"));
		txSkin = new Skin(txAtlas);

		return txSkin.getDrawable(type);
	}
	
	public class CoopAppIcon implements IGdxActor {
		
		private Image icon;
		
		public CoopAppIcon() {
			
		}

		@Override
		public void set(Object _object) {
			icon = (Image) _object;
		}

		@Override
		public Actor get() {
			return icon;
		}
		
	}

}
