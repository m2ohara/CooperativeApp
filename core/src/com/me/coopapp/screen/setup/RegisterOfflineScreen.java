package com.me.coopapp.screen.setup;

import com.me.coopapp.GameLogic;
import com.me.coopapp.Types.ScreenTypes;
import com.me.coopapp.gamestate.GameState;
import com.me.coopapp.ui.GdxButton;
import com.me.coopapp.ui.GdxIcon;
import com.me.coopapp.ui.GdxTextField;
import com.me.coopapp.ui.Screen;
import com.me.coopapp.ui.ScreenSwitchButton;

public class RegisterOfflineScreen extends Screen {
	
	
	//Singleton
	public RegisterOfflineScreen() {
		
	}

	public void SetUI() {
		
		
		//Set layout
		new GdxTextField(0, 80);
		new GdxTextField(0, 10);
		new GdxButton("UploadPhotoBtn", -100, -75);
		new GdxIcon("UploadPhotoIcon", -170, -150);
		new GdxIcon("UploadPhotoIcon", -90, -150);
		new GdxIcon("UploadPhotoIcon", -10, -150);
		new ScreenSwitchButton("CreateProfileBtn", 0, -250, ScreenTypes.loadingTexture);
		
		GameLogic.getInstance().GameTasks.add(GameState.getGameState());

	}
	

}
