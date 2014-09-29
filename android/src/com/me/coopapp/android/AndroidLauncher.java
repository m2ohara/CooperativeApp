package com.me.coopapp.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.me.coopapp.CoopApp;

public class AndroidLauncher extends AndroidApplication {
	
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		CoopApp app = new CoopApp();
		initialize(app, config);
		//Obtain db connection from jdbc driver
		app.SetConnection(new AndroidActionResolver(getContext()).getConnection());
		
	}
}
