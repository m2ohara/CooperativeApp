package com.me.coopapp.screen.setup;

import com.me.coopapp.Screen;
import com.me.coopapp.ScreenState;
import com.me.coopapp.ui.GdxButton;
import com.me.coopapp.ui.GdxIcon;
import com.me.coopapp.ui.GdxSwitchScreenBtn;
import com.me.coopapp.ui.GdxTextField;
import com.me.coopapp.ui.ObserverAddUser;
import com.me.coopapp.ui.ObserverSetUser;
import com.me.coopapp.ui.ObserverSetUser.ObservableType;

public class RegisterOfflineScreen extends Screen {
	
	
	//Singleton
	public RegisterOfflineScreen() {
		
	}

	public void SetUI() {
		
		

		
		GdxSwitchScreenBtn btn = new GdxSwitchScreenBtn("CreateProfileBtn", 0, -250, ScreenState.Types.createProfileTexture);
		//Add action to insert user state to DB
		btn.addObserver(new ObserverAddUser());
		
		//Set layout
		new GdxTextField(0, 80, "Name", ScreenState.Types.createProfileTexture).addObserver(new ObserverSetUser(ObservableType.NAME));
		new GdxTextField(0, 10, "Email", ScreenState.Types.createProfileTexture).addObserver(new ObserverSetUser(ObservableType.EMAIL));
		new GdxButton("UploadPhotoBtn", -100, -75, ScreenState.Types.createProfileTexture);
		new GdxIcon("UploadPhotoIcon", -170, -150, ScreenState.Types.createProfileTexture);
		new GdxIcon("UploadPhotoIcon", -90, -150, ScreenState.Types.createProfileTexture);
		new GdxIcon("UploadPhotoIcon", -10, -150, ScreenState.Types.createProfileTexture);

	}
	

}
