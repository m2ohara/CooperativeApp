package com.me.coopapp.screen.setup;

import java.util.Arrays;
import java.util.List;

import com.me.coopapp.Types;

public class Register {
	
	//Singleton
	public Register() {
		
	}
	
	//Declare screen properties
	Types.ScreenTypes screenType = Types.ScreenTypes.registerTexture;
	List<Types.ButtonTypes> buttons = Arrays.asList(Types.ButtonTypes.facebookBtn, Types.ButtonTypes.registerBtn);
	
	
	//Create listener for button touch
	

}
