package com.me.coopapp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Screen {
	
	private static Screen screenInstance = null;
	public Texture texture;
	
	
	protected Screen() {
	
	}
	
	public static Screen getScreenInstance() {
		if(screenInstance == null) {
			screenInstance = new Screen();
		}
		return screenInstance;
	}
	
	public void change() {
	
	}
	
	public void update(ScreenTypes type) {
	
		if(texture != null) {
			if(type == ScreenTypes.startTexture)
				texture = new Texture("StartTexture.jpg");
		}
		//Get start screen if null
		else {
			texture = new Texture("badlogic.jpg");
		}
	}
	

}
