package com.me.coopapp;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.me.coopapp.gamestate.GameState;
import com.me.coopapp.gamestate.GdxGameStateItem;
import com.me.coopapp.ui.GdxButton;

public class GameLogic extends Thread {
	
	private static GameLogic processInstance = new GameLogic();
	public ArrayList<ITask> UserTasks = new ArrayList<ITask>();
	public ArrayList<ITask> GameTasks = new ArrayList<ITask>();
	public ArrayList<ITask> ScreenTasks = new ArrayList<ITask>();
	
	private GameLogic() {
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

		//If new setup create new settings 
		Setup setup = new Setup();
		if(!setup.isTableExists()) {
			//Setup data base
			new Setup().createDatabaseFromFile();
		} 
		//Perform appropriate user action
//		UserTasks.add(new UserState(userEntity));
		
		//TO DO: Place in new setup condition. Setup registration screen
		ScreenState.getScreenInstance().type = Types.ScreenTypes.register1Texture;
		ScreenTasks.add(ScreenState.getScreenInstance());
		
		GameState.getGameState().items.add(new GdxGameStateItem(new GdxButton("SetupBtn1", 0, 90)));
		GameState.getGameState().items.add(new GdxGameStateItem(new GdxButton("SetUpBtn2", 0, -90)));
		
		
		GameTasks.add(GameState.getGameState());
	
	}
	
	public void processScreenState() {
		
		//Process current screen state
		for(ITask t : ScreenTasks) {
			t.perform(false);
		}
		ScreenTasks.clear();
	}
	
	private void processUserState(boolean isGdxThread) {
		
		if(!isGdxThread) {
			//Process current user state
			Iterator<ITask> it = UserTasks.iterator();
			while(it.hasNext()) {
				ITask task = it.next();
				task.perform(false);
				
				if(task.isTaskComplete()) {
					it.remove();
				}
			}
		}
	}
	
	private void processGameState(boolean isGdxThread) {

		//Process current game state
		for(ITask t : GameTasks) {
			t.perform(isGdxThread);
		}
	}
	
	
	public void process() {
		
		processUserState(false);
		
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
	
	//Perform any actions that take place in the Gdx thread
	private void syncToGdxThread() {
		
	    Gdx.app.postRunnable(new Runnable() {
	        @Override
	        public void run() {
		       processScreenState();
	           processGameState(true);
	        }
	     });
	}
}
