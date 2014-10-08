package com.me.coopapp;

import java.sql.Connection;
import java.util.ArrayList;

import org.sqlite.SQLiteConnection;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ProcessManager implements Runnable {
	
	private static ProcessManager processInstance = new ProcessManager();
	private static User userState;
	private static Screen screen;
	private SQLiteConnection connection;
	public static ArrayList<Task> Tasks = new ArrayList<Task>();
	
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
		
		Setup setupState = new Setup(connection);
		
		//Configure app
		
		//Load settings
		if(setupState.isTableExists()) {
			userState.action = "Get";
		}
		
		//If new setup create new settings 
		else if(setupState.isTableExists() == false) {
			
			setupState.createDatabaseFromFile();
			userState.action = "Insert";
		} 
		
		Tasks.add(new Task(userState));
	
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
	
	private void UserState() {
		//Process current user state
		for(Task t : Tasks) {
			t.Perform();
		}
	}
	
	private void GameState() {
		//Process current game state
	}
	
	public void SetConnection(SQLiteConnection conn) {
		connection = conn;
	}
	
	public Connection GetConnection() {
		return connection;
	}
	
	public void process() {
		
		UserState();
		
		GameState();
		
	}

	@Override
	public void run() {
		
		process();
		try {
			this.wait(1000);
		}
		catch(Exception e) {
			
		}
		
	}
	
	public void dispose() {
		this.dispose();
	}

}
