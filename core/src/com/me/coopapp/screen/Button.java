package com.me.coopapp.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class Button {

	public TextButton instance;
	
	public String text;
	public TextureAtlas buttonAtlas;
	public BitmapFont font = new BitmapFont();
	public Skin skin = new Skin();
	public TextButtonStyle style = new TextButtonStyle();
	
	public Button() {

	}
	
	public void instantiate() {
		
		buttonAtlas = new TextureAtlas(Gdx.files.internal("Buttons.pack"));
		skin.addRegions(buttonAtlas);
		style.font = font;
		style.up = skin.getDrawable("SetUpBtn2");
		style.down = skin.getDrawable("SetUpBtn2-down");
		instance = new TextButton(text, style);
		
		setWidth();
		setHeight();
	}
	
	private void setWidth() {
		instance.setWidth(202);
	}
	
	private void setHeight() {
		instance.setHeight(76);
	}

}
