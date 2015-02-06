package com.me.coopapp.screen.setup;

import com.me.coopapp.Screen;
import com.me.coopapp.ScreenState;
import com.me.coopapp.ui.GdxIcon;
import com.me.coopapp.ui.GdxSwitchScreenBtn;
import com.me.coopapp.ui.GdxTextField;
import com.me.coopapp.ui.ObserverSetUser;
import com.me.coopapp.ui.ObserverUpdateUser;
import com.me.coopapp.ui.ObserverSetUser.ObservableType;

public class CreateProfileScreen extends Screen {
	
	public CreateProfileScreen() {
		
	}
	
	public void SetUI() {
		
		new GdxSwitchScreenBtn("PlayGameBtn", 0, -250, ScreenState.Types.gameWorldTexture, ScreenState.Types.createProfileTexture).addObserver(new ObserverUpdateUser());
		
		new GdxTextField(0, 80, "Alias", ScreenState.Types.createProfileTexture).addObserver(new ObserverSetUser(ObservableType.ALIAS));
		
		new GdxIcon("UploadPhotoIcon", -170, -150, ScreenState.Types.createProfileTexture);
		new GdxIcon("UploadPhotoIcon", -90, -150, ScreenState.Types.createProfileTexture);
		new GdxIcon("UploadPhotoIcon", -10, -150, ScreenState.Types.createProfileTexture);
		
	}

}
