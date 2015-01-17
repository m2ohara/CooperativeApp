package com.me.coopapp.setup;

import com.me.coopapp.Screen;
import com.me.coopapp.Types;
import com.me.coopapp.Types.ScreenTypes;
import com.me.coopapp.ui.GdxSwitchScreenBtn;

public class RegisterOptionsScreen extends Screen {
	
	public void SetUI() {
		
		//Set layout
		GdxSwitchScreenBtn btn1 = new GdxSwitchScreenBtn("SetupBtn1", 0, 90, ScreenTypes.register2Texture, Types.ScreenTypes.register1Texture);
		GdxSwitchScreenBtn btn2 = new GdxSwitchScreenBtn("SetUpBtn2", 0, -90, ScreenTypes.register2Texture, Types.ScreenTypes.register1Texture);
		
		//Add screen's disposable items
		btn1.getDisposer().addGdxItemToDispose(btn2);
		btn2.getDisposer().addGdxItemToDispose(btn1);

		//Perform game logic tasks
		//TO DO: Review for intended usage
//		GameLogic.getInstance().GameTasks.add(GameState.get());

	}

}
