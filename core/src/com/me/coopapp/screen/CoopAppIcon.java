package com.me.coopapp.screen;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

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
