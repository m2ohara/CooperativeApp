package com.me.coopapp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Screen implements ITask {
	
	private static Screen screenInstance = null;
	public Texture texture;
	public float x;
	public float y;
	private Types.ScreenTypes current;
	public Types.ScreenTypes type;
	
	
	private Screen() {
		//Default screen
		texture = new Texture("StartTexture.jpg");
		setRelativePosition();
	}
	
	public static Screen getScreenInstance() {
		if(screenInstance == null) {
			screenInstance = new Screen();
		}
		return screenInstance;
	}
	
	public void set(Types.ScreenTypes type) {
		update(type);
		setRelativePosition();
	}
	
	public void update(Types.ScreenTypes type) {
	
		//Only load if not current screen texture
		if(type != null) {
			if(current != type) {
				//Load screen
				if(type == Types.ScreenTypes.startTexture) {
					texture = new Texture("StartTexture.jpg");
				}
				else if(type == Types.ScreenTypes.loadingTexture) {
					texture = new Texture("LoadingTexture.jpg");
				}
				else if(type == Types.ScreenTypes.registerTexture) {
					texture = new Texture("RegisterTexture.png");
				}
				current = type;
			}
		}
		//Get start screen if null
		else {
			texture = new Texture("StartTexture.jpg");
		}
	}
	
	private void setRelativePosition() {
		
		//Set texture position based on screen size 
		x = (Gdx.graphics.getWidth() - texture.getWidth()) /2 ;
		y = (Gdx.graphics.getHeight()  - texture.getHeight()) / 2;
	}

	@Override
	public void Perform() {
		set(type);
	}
	

}
