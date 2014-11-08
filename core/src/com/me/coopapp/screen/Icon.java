package com.me.coopapp.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

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
		actor.set(new Image(new Texture(type)));
		
	}

}
