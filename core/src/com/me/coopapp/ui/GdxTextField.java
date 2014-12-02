package com.me.coopapp.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.me.coopapp.GameLogic;
import com.me.coopapp.ui.IListenerAction.ListenerActionType;


public class GdxTextField extends GdxActor {
	
	//The text field input label
	private String textValue;
	public String inputValue;
	private ListenerActionType lActionType;
	
	public GdxTextField(float _xCentreOffset, float _yCentreOffset, String _textValue, ListenerActionType _lActionType) {
		super(_xCentreOffset, _yCentreOffset);
		textValue = _textValue == null ? "" : _textValue;
		lActionType = _lActionType;
	}
	
	public void instantiate() {
		actor = new CoopAppTextField();
		
		actor.set(new TextField(textValue, new Skin(Gdx.files.internal("Data/uiskin.json"))));
		
		setListener();
	}
	
	
	public class CoopAppTextField implements IGdxActor {
		
		TextField textField;
		
		public CoopAppTextField() {
			
		}

		@Override
		public void set(Object _object) {
			textField = (TextField) _object;
			
		}

		@Override
		public Actor get() {
			return textField;
		}
		
		public TextField getAsType() {
			return textField;
		}

	}
	
	public void setListener() {
		
		actor.get().addListener(new InputListener() {
			
			public boolean keyDown(InputEvent event, int keyCode) {
				
				if(keyCode == Input.Keys.ENTER) {
					inputValue = ((TextField)actor.get()).getText();
					
					new TextFieldListenerAction(lActionType, inputValue);
					
				}
				return true;
			}
		});
	}

}
