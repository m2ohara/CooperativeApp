package com.me.coopapp.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.ObjectSet;

public class GdxIcon extends CoopAppActor{
	
	public GdxIcon(String _type) {
		super(_type);
	}
	
	public GdxIcon(String _type, float _xCentreOffset, float _yCentreOffset) {
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
	
	//TO DO: Implement disposer
	
	public class CoopAppIcon implements ICoopAppActor {
		
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
