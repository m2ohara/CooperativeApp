package com.me.coopapp.screen.setup;

import java.util.ArrayList;

import com.me.coopapp.GameLogic;
import com.me.coopapp.Types.ScreenTypes;
import com.me.coopapp.gamestate.GameState;
import com.me.coopapp.ui.GdxActor;
import com.me.coopapp.ui.GdxButton;
import com.me.coopapp.ui.GdxIcon;
import com.me.coopapp.ui.GdxSwitchScreenBtn;
import com.me.coopapp.ui.GdxTextField;
import com.me.coopapp.ui.ListenerAddUser;
import com.me.coopapp.ui.ListenerSetUser;
import com.me.coopapp.ui.ListenerSetUser.ObservableType;
import com.me.coopapp.ui.Screen;

public class RegisterOfflineScreen extends Screen {
	
	
	//Singleton
	public RegisterOfflineScreen() {
		
	}

	@SuppressWarnings("serial")
	public void SetUI() {
		
		

		
		GdxSwitchScreenBtn btn = new GdxSwitchScreenBtn("CreateProfileBtn", 0, -250, ScreenTypes.createProfileTexture);
		//Add action to insert user state to DB
		btn.addListener(new ListenerAddUser());
		//Set items for btn to dispose of on click
		btn.getDisposer().addGdxItemToDispose( new ArrayList<GdxActor>() {{
			//Set layout
			new GdxTextField(0, 80, "Name").addListener(new ListenerSetUser(ObservableType.NAME));
			new GdxTextField(0, 10, "Email").addListener(new ListenerSetUser(ObservableType.EMAIL));
			new GdxButton("UploadPhotoBtn", -100, -75);
			new GdxIcon("UploadPhotoIcon", -170, -150);
			new GdxIcon("UploadPhotoIcon", -90, -150);
			new GdxIcon("UploadPhotoIcon", -10, -150);
		}});

		//Perform game logic tasks
		//TO DO: Review for intended usage 
//		GameLogic.getInstance().GameTasks.add(GameState.get());

	}
	

}
