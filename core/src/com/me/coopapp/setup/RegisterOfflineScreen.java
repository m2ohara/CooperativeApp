package com.me.coopapp.setup;

import com.me.coopapp.Screen;
import com.me.coopapp.Types.ScreenTypes;
import com.me.coopapp.ui.GdxButton;
import com.me.coopapp.ui.GdxIcon;
import com.me.coopapp.ui.GdxSwitchScreenBtn;
import com.me.coopapp.ui.GdxTextField;
import com.me.coopapp.ui.ListenerAddUser;
import com.me.coopapp.ui.ListenerSetUser;
import com.me.coopapp.ui.ListenerSetUser.ObservableType;

public class RegisterOfflineScreen extends Screen {
	
	
	//Singleton
	public RegisterOfflineScreen() {
		
	}

	public void SetUI() {
		
		

		
		GdxSwitchScreenBtn btn = new GdxSwitchScreenBtn("CreateProfileBtn", 0, -250, ScreenTypes.createProfileTexture);
		//Add action to insert user state to DB
		btn.addListener(new ListenerAddUser());
		
		//Set layout
		new GdxTextField(0, 80, "Name", ScreenTypes.createProfileTexture).addListener(new ListenerSetUser(ObservableType.NAME));
		new GdxTextField(0, 10, "Email", ScreenTypes.createProfileTexture).addListener(new ListenerSetUser(ObservableType.EMAIL));
		new GdxButton("UploadPhotoBtn", -100, -75, ScreenTypes.createProfileTexture);
		new GdxIcon("UploadPhotoIcon", -170, -150, ScreenTypes.createProfileTexture);
		new GdxIcon("UploadPhotoIcon", -90, -150, ScreenTypes.createProfileTexture);
		new GdxIcon("UploadPhotoIcon", -10, -150, ScreenTypes.createProfileTexture);

	}
	

}