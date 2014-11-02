package com.me.coopapp.screen.setup;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.me.coopapp.GameLogic;
import com.me.coopapp.Types.ScreenTypes;
import com.me.coopapp.gamestate.GameState;
import com.me.coopapp.gamestate.GdxGameStateItem;
import com.me.coopapp.screen.Button;
import com.me.coopapp.screen.Screen;
import com.me.coopapp.screen.ScreenSwitchButton;

public class RegisterOfflineScreen extends Screen {
	
	private TextField nameField;
	private TextField emailField;
	private Image pictureOne;
	private Image pictureTwo;
	private Image pictureThree;
	private Button uploadImage;
	private Button createProfile;
	
	//Singleton
	public RegisterOfflineScreen() {
		
	}

	public void SetUI() {
		
//		nameField = new TextField("Name", new Skin());
//		emailField = new TextField("Email", new Skin());
//		pictureOne = new Image();
//		pictureTwo = new Image();
//		pictureThree = new Image();
		
		GameState.getGameState().items.add(new GdxGameStateItem(new Button("UploadPhotoBtn", -100, -100)));
		GameState.getGameState().items.add(new GdxGameStateItem(new ScreenSwitchButton("CreateProfileBtn", 0, -250, ScreenTypes.loadingTexture)));
		GameLogic.getInstance().GameTasks.add(GameState.getGameState());

	}
	

}
