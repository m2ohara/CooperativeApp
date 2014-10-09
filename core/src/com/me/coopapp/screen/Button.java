package com.me.coopapp.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class Button {

	public TextButton button;
	
	public String text;
	public TextureAtlas buttonAtlas;
	public BitmapFont font = new BitmapFont();
	public Skin skin = new Skin();
	public TextButtonStyle style = new TextButtonStyle();
	
	public Button(String _text) {
		text = _text;
		
		setButton();
		setWidth();
		setHeight();
	}
	
	private void setButton() {
		
		buttonAtlas = new TextureAtlas(Gdx.files.internal("Buttons.pack"));
		skin.addRegions(buttonAtlas);
		style.font = font;
		style.up = skin.getDrawable("BtnSetup2");
		style.down = skin.getDrawable("BtnSetup2-down");
		button = new TextButton(text, style);
	}
	
	private void setWidth() {
		button.setWidth(0);
	}
	
	private void setHeight() {
		button.setHeight(0);
	}

}
