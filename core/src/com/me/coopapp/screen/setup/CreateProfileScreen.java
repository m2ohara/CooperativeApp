package com.me.coopapp.screen.setup;

import com.me.coopapp.Types.ScreenTypes;
import com.me.coopapp.ui.GdxIcon;
import com.me.coopapp.ui.GdxSwitchScreenBtn;
import com.me.coopapp.ui.GdxTextField;
import com.me.coopapp.ui.ListenerSetUser;
import com.me.coopapp.ui.ListenerSetUser.ObservableType;
import com.me.coopapp.ui.ListenerUpdateUser;
import com.me.coopapp.ui.Screen;

public class CreateProfileScreen extends Screen {
	
	public CreateProfileScreen() {
		
	}
	
	public void SetUI() {
		
		new GdxSwitchScreenBtn("PlayGameBtn", 0, -250, ScreenTypes.startTexture).addListener(new ListenerUpdateUser());
		
		new GdxTextField(0, 80, "Alias", ScreenTypes.playGameTexture).addListener(new ListenerSetUser(ObservableType.ALIAS));
		
		new GdxIcon("UploadPhotoIcon", -170, -150, ScreenTypes.playGameTexture);
		new GdxIcon("UploadPhotoIcon", -90, -150, ScreenTypes.playGameTexture);
		new GdxIcon("UploadPhotoIcon", -10, -150, ScreenTypes.playGameTexture);
		
	}

}
