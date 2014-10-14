package com.me.coopapp.gamestate;

import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.me.coopapp.screen.Button;

public class GLContextItem implements IGLContext {

	String name;
	Object item;
	ArrayList<Object> dependencies = new ArrayList<Object>();
	
	public GLContextItem(Object _item) {
		item = _item;
	}
	
	public void initialiseItem() {
		try {
			if(item.getClass() == Class.forName("com.badlogic.gdx.scenes.scene2d.Actor")) { 
				item = new Actor();
			}
			else if(item.getClass() == Class.forName("com.me.coopapp.screen.Button")) {
				((Button)item).instantiate();
			}
		}
		catch(ClassNotFoundException e) {
			System.out.println("Unable to resolve class "+e);
		}
	}

}
