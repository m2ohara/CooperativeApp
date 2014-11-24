package com.me.coopapp.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.me.coopapp.CoopApp;
import com.me.coopapp.dal.SQLConnection;

public class DesktopLauncher {
	
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 900;
		CoopApp app = new CoopApp();
		new LwjglApplication(app, config);
		
		//Obtain db connection from jdbc driver
		new SQLConnection(new DesktopActionResolver());
	}
}
