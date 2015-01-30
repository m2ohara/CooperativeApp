package com.me.coopapp.gamestate;

import com.me.coopapp.gamestate.GameStateItem.NextThreadAction;

public interface IGLGPerform {
	
	public NextThreadAction getIsNextAction();
	public void setIsNextAction(NextThreadAction action);
	public Object perform(Object parameter);

}
