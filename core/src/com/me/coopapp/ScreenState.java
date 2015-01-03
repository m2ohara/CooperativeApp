package com.me.coopapp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.me.coopapp.gamestate.GameState;
import com.me.coopapp.screen.setup.RegisterOfflineScreen;
import com.me.coopapp.screen.setup.RegisterOptionsScreen;
import com.me.coopapp.ui.Screen;

public class ScreenState implements ITask {
	
	private static ScreenState screenInstance = null;
	private Texture texture;
	private float x;
	private float y;
	private Types.ScreenTypes current;
	private Types.ScreenTypes type;
	private Screen screen;
	private boolean isTaskComplete = false;
	
	
	private ScreenState() {
	}
	
	public static ScreenState getScreenInstance() {
		if(screenInstance == null) {
			screenInstance = new ScreenState();
		}
		return new ScreenState();
	}
	
	public void setTask(Types.ScreenTypes _type) {
		type = _type;
		GameLogic.getInstance()._ScreenTasks.put(this.hashCode(), this);
	}
	
	private void set(Types.ScreenTypes type) {
		update(type);
		setRelativePosition();
	}
	
	private void update(Types.ScreenTypes type) {
	
		//Only load if not current screen texture
		if(type != null) {
			if(current != type) {
				//Load screen
				if(type == Types.ScreenTypes.startTexture) {
					screen = new Screen();
					texture = new Texture("StartTexture.jpg");
				}
				else if(type == Types.ScreenTypes.loadingTexture) {
					screen = new Screen();
					texture = new Texture("LoadingTexture.jpg");
				}
				else if(type == Types.ScreenTypes.register1Texture) {
					screen = new RegisterOptionsScreen();
					texture = new Texture("Register1.png");
				}
				else if(type == Types.ScreenTypes.register2Texture) {
					screen = new RegisterOfflineScreen();
					texture = new Texture("Register2.png");
				}
				else if(type == Types.ScreenTypes.createProfileTexture) {
					screen = new Screen();
					texture = new Texture("createProfile.png");
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
		
		if(isGdxThread) {
			
			GameState.stage.clear();
			
			set(type);
			Actor background = new Image(texture);
			background.setPosition(x, y);
			GameState.stage.addActor(background);
			
			screen.SetUI();
			
			isTaskComplete = true;
		}
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isTaskComplete() {
		return isTaskComplete;
	}
	

}
