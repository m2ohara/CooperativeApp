package com.me.coopapp.screen.setup;

import java.util.ArrayList;
import java.util.Observer;

import com.me.coopapp.GameLogic;
import com.me.coopapp.Types.ScreenTypes;
import com.me.coopapp.gamestate.GameState;
import com.me.coopapp.ui.AddUserListener;
import com.me.coopapp.ui.GdxButton;
import com.me.coopapp.ui.GdxIcon;
import com.me.coopapp.ui.GdxTextField;
import com.me.coopapp.ui.IListenerAction.ListenerActionType;
import com.me.coopapp.ui.Screen;
import com.me.coopapp.ui.ScreenSwitchButton;
import com.me.coopapp.ui.SwitchScreenListener;

public class RegisterOfflineScreen extends Screen {
	
	
	//Singleton
	public RegisterOfflineScreen() {
		
	}

	public void SetUI() {
		
		
		//Set layout
		new GdxTextField(0, 80, "Name", ListenerActionType.SETUSERNAME);
		new GdxTextField(0, 10, "Email", ListenerActionType.SETUSEREMAIL);
		new GdxButton("UploadPhotoBtn", -100, -75);
		new GdxIcon("UploadPhotoIcon", -170, -150);
		new GdxIcon("UploadPhotoIcon", -90, -150);
		new GdxIcon("UploadPhotoIcon", -10, -150);

		new ScreenSwitchButton("CreateProfileBtn", 0, -250, ScreenTypes.createProfileTexture).addListener(
				new ArrayList<Observer>() 
				{/**
				 * 
				 */
					private static final long serialVersionUID = 1L;

					{
						add(new AddUserListener()); 
						add(new SwitchScreenListener());
					}
				}
				);

		GameLogic.getInstance().GameTasks.add(GameState.getGameState());

	}
	

}
