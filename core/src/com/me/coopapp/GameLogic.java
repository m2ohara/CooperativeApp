package com.me.coopapp;

import java.sql.Connection;
import java.util.ArrayList;

//import org.sqlite.SQLiteConnection;

import com.badlogic.gdx.Gdx;
import com.me.coopapp.gamestate.GameState;
import com.me.coopapp.gamestate.GdxGameStateItem;
import com.me.coopapp.screen.Button;

public class GameLogic extends Thread {
	
	private static GameLogic processInstance = new GameLogic();
	private static User userEntity;
	private Connection connection;
	public ArrayList<ITask> UserTasks = new ArrayList<ITask>();
	public ArrayList<ITask> GameTasks = new ArrayList<ITask>();
	public ArrayList<ITask> ScreenTasks = new ArrayList<ITask>();
	
	private GameLogic() {
		userEntity = User.getUser();
		ScreenState.getScreenInstance();
	}
	
	//Retrieve single instance of this class
	public static GameLogic getInstance() {
		if(processInstance == null) {
			processInstance = new GameLogic();
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
		ScreenState.getScreenInstance().type = Types.ScreenTypes.register1Texture;
		ScreenTasks.add(ScreenState.getScreenInstance());
		
		GameState.getGameState().items.add(new GdxGameStateItem(new Button("SetupBtn1", 0, 90)));
		GameState.getGameState().items.add(new GdxGameStateItem(new Button("SetUpBtn2", 0, -90)));
		
		
		GameTasks.add(GameState.getGameState());
	
	}
	
	public void processScreenState() {
		
		//Process current screen state
		for(ITask t : ScreenTasks) {
			t.perform(false);
		}
		ScreenTasks.clear();
	}
	
	private void processUserState() {
		//Process current user state
		for(ITask t : UserTasks) {
			t.perform(false);
		}
		UserTasks.clear();
	}
	
	private void processGameState(boolean isGdxThread) {
		
		ArrayList<ITask> tasksNotComplete = new ArrayList<ITask>();
		
		//Process current game state
		for(ITask t : GameTasks) {
			t.perform(isGdxThread);
			
			//Get any current items that need to perform another action within task
//			if(!t.isTaskComplete()) {
//				tasksNotComplete.add(t);
//			}
		}
		
//		GameTasks.clear();
		
		//Add any new items with actions to be performed
//		GameTasks.addAll(tasksNotComplete);
	}
	
	
	public void process() {
		
		processUserState();
		
		processGameState(false);
		
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
		       processScreenState();
	           processGameState(true);
	        }
	     });
	}
	
	//TODO: Resolve connection
	public void SetConnection(Connection conn) {
		connection = conn;
	}
	
	public Connection GetConnection() {
		return connection;
	}

}
