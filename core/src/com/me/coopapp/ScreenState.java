package com.me.coopapp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.me.coopapp.gamestate.GameState;
import com.me.coopapp.screen.IScreen;
import com.me.coopapp.screen.Screen;
import com.me.coopapp.screen.setup.RegisterOffline;

public class ScreenState implements ITask {
	
	private static ScreenState screenInstance = null;
	public Texture texture;
	public float x;
	public float y;
	private Types.ScreenTypes current;
	public Types.ScreenTypes type;
	private Screen screen;
	
	
	private ScreenState() {
	}
	
	public static ScreenState getScreenInstance() {
		if(screenInstance == null) {
			screenInstance = new ScreenState();
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
				else if(type == Types.ScreenTypes.register1Texture) {
					texture = new Texture("Register1.png");
				}
				else if(type == Types.ScreenTypes.register2Texture) {
					screen = new RegisterOffline();
					texture = new Texture("Register2.png");
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
	public void perform(boolean isGdxThread) {
		set(type);
		Actor background = new Image(texture);
		background.setPosition(x, y);
		GameState.stage.addActor(background);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isTaskComplete() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
