package com.me.coopapp.gamestate;

import java.util.concurrent.ConcurrentHashMap;

public class GlgGameStateItem extends GameStateItem {
	
	public ConcurrentHashMap<Integer, IGLGPerform> tasksToPerform;

	public GlgGameStateItem(Object item, ConcurrentHashMap<Integer, IGLGPerform> tasks) {
		super(item);
		
		tasksToPerform = tasks;
		state = NextThreadAction.YES;
		
	}
	
	public void performTask() {
		if(tasksToPerform.size() != 0) {
			
			IGLGPerform task = tasksToPerform.elements().nextElement();
			
			//If next task is to be performed
			if(task.getIsNextAction() == NextThreadAction.YES) {
				//Perform
				task.perform();
				//Set following action to perform next
				tasksToPerform.elements().nextElement().setIsNextAction(NextThreadAction.YES);
				//Remove performed action
				tasksToPerform.remove(task);
			}
		}
		
	}
	
	

}
