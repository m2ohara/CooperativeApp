package com.me.coopapp.screen.setup;

import com.me.coopapp.GameLogic;
import com.me.coopapp.Types.ScreenTypes;
import com.me.coopapp.gamestate.GameState;
import com.me.coopapp.gamestate.GdxGameStateItem;
import com.me.coopapp.screen.Button;
import com.me.coopapp.screen.Icon;
import com.me.coopapp.screen.Screen;
import com.me.coopapp.screen.ScreenSwitchButton;

public class RegisterOfflineScreen extends Screen {
	
	
	//Singleton
	public RegisterOfflineScreen() {
		
	}

	public void SetUI() {
		
		
		//Set layout
		GameState.getGameState().items.add(new GdxGameStateItem(new Button("UploadPhotoBtn", -100, -100)));
		GameState.getGameState().items.add(new GdxGameStateItem(new Icon("UploadPhotoIcon", -100, -150)));
		GameState.getGameState().items.add(new GdxGameStateItem(new Icon("UploadPhotoIcon", -170, -150)));
		GameState.getGameState().items.add(new GdxGameStateItem(new Icon("UploadPhotoIcon", -240, -150)));
		GameState.getGameState().items.add(new GdxGameStateItem(new ScreenSwitchButton("CreateProfileBtn", 0, -250, ScreenTypes.loadingTexture)));
		
		GameLogic.getInstance().GameTasks.add(GameState.getGameState());

	}
	

}
