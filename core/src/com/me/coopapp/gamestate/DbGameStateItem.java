package com.me.coopapp.gamestate;

import java.sql.ResultSet;

import com.me.coopapp.dal.ISQLTransaction;
import com.me.coopapp.dispose.Disposer;

public class DbGameStateItem extends GameStateItem {
	

	public DbGameStateItem(Object _item) {
		super(_item);
		
		state = NextThreadAction.GLGTRANSACTION;
	}

	public ResultSet performDbTransaction() {
		
		state = NextThreadAction.DISPOSE;
		
		return ((ISQLTransaction) item).performTransaction();
	}


}
