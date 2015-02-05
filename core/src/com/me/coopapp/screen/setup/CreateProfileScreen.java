package com.me.coopapp.screen.setup;

import com.me.coopapp.Screen;
import com.me.coopapp.ScreenState;
import com.me.coopapp.ui.GdxIcon;
import com.me.coopapp.ui.GdxSwitchScreenBtn;
import com.me.coopapp.ui.GdxTextField;
import com.me.coopapp.ui.ListenerSetUser;
import com.me.coopapp.ui.ListenerUpdateUser;
import com.me.coopapp.ui.ListenerSetUser.ObservableType;

public class CreateProfileScreen extends Screen {
	
	public CreateProfileScreen() {
		
	}
	
	public void SetUI() {
		
		new GdxSwitchScreenBtn("PlayGameBtn", 0, -250, ScreenState.Types.gameWorldTexture).addListener(new ListenerUpdateUser());
		
		new GdxTextField(0, 80, "Alias", ScreenState.Types.createProfileTexture).addListener(new ListenerSetUser(ObservableType.ALIAS));
		
		new GdxIcon("UploadPhotoIcon", -170, -150, ScreenState.Types.createProfileTexture);
		new GdxIcon("UploadPhotoIcon", -90, -150, ScreenState.Types.createProfileTexture);
		new GdxIcon("UploadPhotoIcon", -10, -150, ScreenState.Types.createProfileTexture);
		
	}

}
