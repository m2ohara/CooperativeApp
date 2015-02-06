package com.me.coopapp.gamestate;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import com.me.coopapp.ScreenState;

public class GlgGameStateItem extends GameStateItem {
	
	public LinkedHashMap<Integer, IGLGPerform> tasksToPerform;

	public GlgGameStateItem(Object item, LinkedHashMap<Integer, IGLGPerform> tasks, ScreenState.Types screen) {
		super(item);
		
		tasksToPerform = tasks;
		state = NextThreadAction.YES;
		this.screen = screen;
		
	}
	
	public void performTask() {
		if(tasksToPerform.size() != 0) {
			
			Iterator<Entry<Integer, IGLGPerform>> it = tasksToPerform.entrySet().iterator();
			while(it.hasNext()) {
				IGLGPerform task = it.next().getValue();
				
				//If next task is to be performed
				if(task.getIsNextAction() == NextThreadAction.YES) {
					//Perform
					task.perform();
					//Remove performed action
					it.remove();
					
					if(it.hasNext()) {
						//Set following action to perform next
						IGLGPerform nextTask = it.next().getValue();
						nextTask.setIsNextAction(NextThreadAction.YES);
					}
				}
			}
		}
		else {
			this.disposeGSItem();
		}
		
	}
	
	

}
