package com.me.coopapp.gamestate;

import java.sql.ResultSet;
import com.me.coopapp.dal.ISQLTransaction;

public class DbGameStateItem extends GameStateItem {
	

	public DbGameStateItem(Object _item) {
		super(_item);
		
		state = NextThreadAction.GLGTRANSACTION;
		
		//TO DO: Set disposer
	}

	public ResultSet performDbTransaction() {
		
		state = NextThreadAction.FINISHED;
		return ((ISQLTransaction) item).performTransaction();
	}


}
