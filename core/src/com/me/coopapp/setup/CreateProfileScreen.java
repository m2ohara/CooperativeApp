package com.me.coopapp.setup;

import com.me.coopapp.Screen;
import com.me.coopapp.Types.ScreenTypes;
import com.me.coopapp.ui.GdxIcon;
import com.me.coopapp.ui.GdxSwitchScreenBtn;
import com.me.coopapp.ui.GdxTextField;
import com.me.coopapp.ui.ListenerSetUser;
import com.me.coopapp.ui.ListenerSetUser.ObservableType;
import com.me.coopapp.ui.ListenerUpdateUser;

public class CreateProfileScreen extends Screen {
	
	public CreateProfileScreen() {
		
	}
	
	public void SetUI() {
		
		new GdxSwitchScreenBtn("PlayGameBtn", 0, -250, ScreenTypes.gameWorldTexture).addListener(new ListenerUpdateUser());
		
		new GdxTextField(0, 80, "Alias", ScreenTypes.gameWorldTexture).addListener(new ListenerSetUser(ObservableType.ALIAS));
		
		new GdxIcon("UploadPhotoIcon", -170, -150, ScreenTypes.gameWorldTexture);
		new GdxIcon("UploadPhotoIcon", -90, -150, ScreenTypes.gameWorldTexture);
		new GdxIcon("UploadPhotoIcon", -10, -150, ScreenTypes.gameWorldTexture);
		
	}

}
