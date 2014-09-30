package com.me.coopapp;

import java.sql.Connection;

import org.sqlite.SQLiteConnection;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ProcessManager {
	
	private static ProcessManager processInstance = new ProcessManager();
	private static User userState;
	private static Screen screen;
	private SQLiteConnection connection;
	
	private ProcessManager() {
		userState = User.getUser();
	}
	
	//Retrieve single instance of this class
	public static ProcessManager getProcessManager() {
		if(processInstance == null) {
			processInstance = new ProcessManager();
		}
		return processInstance;
	}
	
	public void Setup() {
		
		Setup createDAL = new Setup(connection);
		
		//Configure app
		
		//Load settings
		if(createDAL.isTableExists()) {
			
		}
		
		//If new setup create new settings 
		else if(createDAL.isTableExists() == false) {
			createDAL.createDatabaseFromFile();
		} 
	
	}
	
	public void ScreenState(SpriteBatch batch) {
		//Default screen
		ScreenTypes screenType = ScreenTypes.startTexture;
		
		//Process current screen state
		screen = Screen.getScreenInstance();
		screen.update(screenType);
		
		//Render 
		batch.draw(screen.texture, 0, 0);
		
	}
	
	public void UserState() {
		//Process current user state
	}
	
	public void GameState() {
		//Process current game state
	}
	
	public void SetConnection(SQLiteConnection conn) {
		connection = conn;
	}
	
	public Connection GetConnection() {
		return connection;
	}

}
