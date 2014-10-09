package com.me.coopapp;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Observable;

import org.sqlite.SQLiteConnection;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.coopapp.screen.Button;

public class ProcessManager extends Observable implements Runnable {
	
	private static ProcessManager processInstance = new ProcessManager();
	private static User userEntity;
	private SQLiteConnection connection;
	public ArrayList<ITask> UserTasks = new ArrayList<ITask>();
	public ArrayList<ITask> GameTasks = new ArrayList<ITask>();
	public ArrayList<ITask> ScreenTasks = new ArrayList<ITask>();
	
	private ProcessManager() {
		userEntity = User.getUser();
		Screen.getScreenInstance();
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
		
		//If already setup load settings
		if(setupState.isTableExists()) {
			userEntity.action = "Get";
		}
		
		//If new setup create new settings 
		else if(setupState.isTableExists() == false) {
			
			//Setup data base
			setupState.createDatabaseFromFile();
			userEntity.action = "Insert";
		} 
		//Perform appropriate user action
//		UserTasks.add(new UserState(userEntity));
		
		//Setup registration screen
		Screen.getScreenInstance().type = Types.ScreenTypes.registerTexture;
		ScreenTasks.add(Screen.getScreenInstance());
		
		//Add actors
		GameState.getGameState().SetActors(new Button("").button );
		GameTasks.add(GameState.getGameState());
		
		//Start logic thread
		new Thread(this).start();
	
	}
	
	public void ScreenState() {
		
		//Process current screen state
		for(ITask t : ScreenTasks) {
			t.Perform();
		}
		ScreenTasks.clear();
	}
	
	private void UserState() {
		//Process current user state
		for(ITask t : UserTasks) {
			t.Perform();
		}
		UserTasks.clear();
	}
	
	private void GameState() {
		//Process current game state
		for(ITask t : GameTasks) {
			t.Perform();
		}
		GameTasks.clear();
	}
	
	public void process() {
		
		UserState();
		
		GameState();
		
//		ScreenState();
		
	}

	@Override
	public void run() {
		
		process();
		try {
			this.wait(100);
		}
		catch(Exception e) {
			
		}
		
	}
	
	public void dispose() {
		this.dispose();
	}
	
	//TODO: Resolve connection
	public void SetConnection(SQLiteConnection conn) {
		connection = conn;
	}
	
	public Connection GetConnection() {
		return connection;
	}

}
