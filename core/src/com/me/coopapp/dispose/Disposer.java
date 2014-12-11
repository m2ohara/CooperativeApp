package com.me.coopapp.dispose;

import java.util.ArrayList;

import com.me.coopapp.gamestate.GameStateItem;

public class Disposer implements IDisposer {
	
	private GameStateItem itemToDispose;
	private ArrayList<GameStateItem> itemsToDispose;
	
	public Disposer() {
		
	}

	@Override
	public void dispose() {
		itemToDispose.disposeGSItem();
	}
	
	public void AddItemToDispose(GameStateItem _itemToDispose) {
		
		itemsToDispose = itemsToDispose == null ? new ArrayList<GameStateItem>() : itemsToDispose;
		
		itemsToDispose.add(_itemToDispose);
	}

}
