package com.me.coopapp.screen.setup;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.me.coopapp.screen.Button;
import com.me.coopapp.screen.Screen;

public class RegisterOffline extends Screen {
	
	private TextField nameField;
	private TextField emailField;
	private Image pictureOne;
	private Image pictureTwo;
	private Image pictureThree;
	private Button uploadImage;
	private Button createProfile;
	
	//Singleton
	public RegisterOffline() {
		
	}

	public void SetUI() {
		
		nameField = new TextField("Name", new Skin());
		emailField = new TextField("Email", new Skin());
		pictureOne = new Image();
		pictureTwo = new Image();
		pictureThree = new Image();
		
		uploadImage = new Button("Upload", 50, -50);
		createProfile = new Button("Profile", 80, -50);

	}
	
	private void SetButtons() {
		
	}
	

}
