package com.me.coopapp.screen.setup;

import java.util.ArrayList;
import java.util.Observer;

import com.me.coopapp.GameLogic;
import com.me.coopapp.Types.ScreenTypes;
import com.me.coopapp.gamestate.GameState;
import com.me.coopapp.ui.ListenerAddUser;
import com.me.coopapp.ui.GdxButton;
import com.me.coopapp.ui.GdxIcon;
import com.me.coopapp.ui.GdxTextField;
import com.me.coopapp.ui.Screen;
import com.me.coopapp.ui.GdxSwitchScreenBtn;
import com.me.coopapp.ui.ListenerSwitchScreen;
import com.me.coopapp.ui.ListenerSetUser;
import com.me.coopapp.ui.ListenerSetUser.ObservableType;

public class RegisterOfflineScreen extends Screen {
	
	
	//Singleton
	public RegisterOfflineScreen() {
		
	}

	public void SetUI() {
		
		
		//Set layout
		new GdxTextField(0, 80, "Name").addListener(new ListenerSetUser(ObservableType.NAME));
		new GdxTextField(0, 10, "Email").addListener(new ListenerSetUser(ObservableType.EMAIL));
		new GdxButton("UploadPhotoBtn", -100, -75);
		new GdxIcon("UploadPhotoIcon", -170, -150);
		new GdxIcon("UploadPhotoIcon", -90, -150);
		new GdxIcon("UploadPhotoIcon", -10, -150);

		new GdxSwitchScreenBtn("CreateProfileBtn", 0, -250, ScreenTypes.createProfileTexture).addListener(
				new ArrayList<Observer>() 
				{/**
				 * 
				 */
					private static final long serialVersionUID = 1L;

					{
						add(new ListenerAddUser()); 
						add(new ListenerSwitchScreen());
					}
				}
				);

		//Perform game logic tasks
		//TO DO: Review for intended usage 
		GameLogic.getInstance().GameTasks.add(GameState.get());

	}
	

}
