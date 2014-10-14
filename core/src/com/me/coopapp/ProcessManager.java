package com.me.coopapp;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Observable;

import org.sqlite.SQLiteConnection;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.me.coopapp.gamestate.GameState;
import com.me.coopapp.gamestate.GameStateItem;
import com.me.coopapp.gamestate.GameStateItem.WaitingState;
import com.me.coopapp.screen.Button;

public class ProcessManager extends Thread {
	
	private static ProcessManager processInstance = new ProcessManager();
	private static User userEntity;
	private SQLiteConnection connection;
	public ArrayList<ITask> UserTasks = new ArrayList<ITask>();
	public ArrayList<ITask> GameTasks = new ArrayList<ITask>();
	public ArrayList<ITask> ScreenTasks = new ArrayList<ITask>();
	
	public ArrayList<Object> gdxItems = new ArrayList<Object>();
	
	private ProcessManager() {
		userEntity = User.getUser();
		ScreenState.getScreenInstance();
	}
	
	//Retrieve single instance of this class
	public static ProcessManager getProcessManager() {
		if(processInstance == null) {
			processInstance = new ProcessManager();
		}
		return processInstance;
	}
	
	public void processSetup() {
		
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
		UserTasks.add(new UserState(userEntity));
		
		//TO DO: Place in new setup condition. Setup registration screen
		ScreenState.getScreenInstance().type = Types.ScreenTypes.registerTexture;
		ScreenTasks.add(ScreenState.getScreenInstance());
		
		Button b = new Button();
		GameStateItem gItem = new GameStateItem(b);
		gItem.state = GameStateItem.WaitingState.GdxInstantiate;
		GameState.getGameState().items.add(gItem);
		GameTasks.add(GameState.getGameState());
	
	}
	
	public void processScreenState() {
		
		//Process current screen state
		for(ITask t : ScreenTasks) {
			t.Perform();
		}
		ScreenTasks.clear();
	}
	
	private void processUserState() {
		//Process current user state
		for(ITask t : UserTasks) {
			t.Perform();
		}
		UserTasks.clear();
	}
	
	private void processGameState() {
		//Process current game state
		for(ITask t : GameTasks) {
			t.Perform();
			
			performGdxOutcome(t);
		}
//		GameTasks.clear();
	}
	
	private void performGdxOutcome(ITask t) {
		//Check task outcome
		ArrayList<GameStateItem> GameItems = (ArrayList<GameStateItem>)t.getTaskItems();
		for(GameStateItem item : GameItems) {
			//If item needs to be instantiated in GL context
			if(item.state == WaitingState.GdxInstantiate && item.stateOutcome != null) {
				gdxItems.add(item.stateOutcome);
				item.state = WaitingState.GlgSet;
			}
		}
	}
	
	public void process() {
		
		processUserState();
		
		processGameState();
		
		syncToGdxThread();
		
	}

	@Override
	public void run() {
		
		while(true) {
			process();
			try {
				//TO DO: Sync sleep period with frame rate
				Thread.sleep(10);
			}
			catch(Exception e) {
				
			}
		}
		
	}
	
	public void dispose() {
		this.dispose();
	}
	
	//This takes place in the Gdx thread
	private void syncToGdxThread() {
		
	    Gdx.app.postRunnable(new Runnable() {
	        @Override
	        public void run() {
	           performGdxProcess();
	        }
	     });
	}
	
	private void performGdxProcess() {
		
		if(!gdxItems.isEmpty()) {
			for(Object item : gdxItems) {
				
				//Initialise any items needing GL context
				if(item instanceof GLContextItem) {
					((GLContextItem) item).initialiseItem();
				}
				
				//Set items needed to render
				if(item instanceof Actor) {
				}
			}
		}
	}
	
	//TODO: Resolve connection
	public void SetConnection(SQLiteConnection conn) {
		connection = conn;
	}
	
	public Connection GetConnection() {
		return connection;
	}

}
