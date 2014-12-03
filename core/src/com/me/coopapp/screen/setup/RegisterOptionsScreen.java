package com.me.coopapp.screen.setup;

import com.me.coopapp.GameLogic;
import com.me.coopapp.gamestate.GameState;
import com.me.coopapp.ui.GdxButton;
import com.me.coopapp.ui.Screen;

public class RegisterOptionsScreen extends Screen {
	
	public void SetUI() {
		
		//Set layout
		new GdxButton("SetupBtn1", 0, 90);
		new GdxButton("SetUpBtn2", 0, -90);

		//Perform game logic tasks
		//TO DO: Review for intended usage
		GameLogic.getInstance().GameTasks.add(GameState.get());

	}

}
