package com.me.coopapp.entity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;

public class App {
	
	private static App instance;
	private static String fileName = "AppConfig"; 
	
	private Map<String, String> credentials = new HashMap<String, String>();


	private App() {
		load();
	}
	
	public static App get() {
		if(instance == null) {
			return new App();
		}
		return instance;
	}
	
	private void load() {
		FileHandle handle = Gdx.files.internal(fileName+".xml");
		
		Element rootElement = null;

		XmlReader xmlR = new XmlReader();
		try {
			rootElement = xmlR.parse(handle);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Element credentialsEl = rootElement.getChildByName("credentials");

		credentials.put("email", ((Element)credentialsEl.getChildByName("email")).getText());
		credentials.put("id", ((Element)credentialsEl.getChildByName("id")).getText());
		
	}
	
	public Map<String, String> getCredentials() {
		return credentials;
	}

	public void setCredentials(Map<String, String> userCredentials) {
		this.credentials = userCredentials;
	}
	
	public String getEmail() { 
		return credentials.get("email");
	}
	
	public String getId() { 
		return credentials.get("id");
	}
	
	

}
