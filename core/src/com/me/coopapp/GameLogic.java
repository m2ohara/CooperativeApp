package com.me.coopapp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

import com.badlogic.gdx.Gdx;
import com.me.coopapp.dal.ISQLTransaction.TransactionType;
import com.me.coopapp.gamestate.DbGameStateItem;
import com.me.coopapp.gamestate.GameState;
import com.me.coopapp.gamestate.GameStateItem;
import com.me.coopapp.ScreenState;

public class GameLogic extends Thread {
	
	private static GameLogic processInstance = new GameLogic();
	public ArrayList<ITask> UserTasks = new ArrayList<ITask>();
	public ArrayList<ITask> GameTasks = new ArrayList<ITask>();
	public ConcurrentHashMap<Integer, ITask> screenTasks = new ConcurrentHashMap<Integer, ITask>();
	public ConcurrentHashMap<Integer, ITask> userTasks = new ConcurrentHashMap<Integer, ITask>();
	
	private GameLogic() {
	}
	
	//Retrieve single instance of this class
	public static GameLogic getInstance() {
		if(processInstance == null) {
			processInstance = new GameLogic();
		}
		return processInstance;
	}
	
	public void processSetup() {

		//Setup new database if required
		DbSetup instance = DbSetup.getInstance();
		instance.setTransaction(TransactionType.GET);
		DbGameStateItem item = new DbGameStateItem(instance);
		GameState.get().items.put(item.hashCode(), item);
		
		
		GameTasks.add(GameState.get());
	
	}
	
	public void processScreenState(boolean isGdxThread) {
		
		//Process current screen state
		for(ITask t : screenTasks.values()) {
			t.perform(isGdxThread);
			
			if(t.isTaskComplete()) {
				t.dispose(); //TO DO: Implement logic
				screenTasks.remove(t.hashCode());
			}
		}
	}
	
	private void processUserState(boolean isGdxThread) {
		
		if(!isGdxThread) {
			//Process current user state
//			Iterator<ITask> it = UserTasks.iterator();
//			while(it.hasNext()) {
			for(ITask t : userTasks.values()) {	
				
//				ITask task = it.next();
				t.perform(false);
				
				//Remove completed
				if(t.isTaskComplete()) {
//					it.remove();
					t.dispose();
					userTasks.remove(t.hashCode());
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
//		       processScreenState(true);
	           processGameState(true);
	        }
	     });
	}
}
