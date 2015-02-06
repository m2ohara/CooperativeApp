package com.me.coopapp.dispose;

import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.me.coopapp.gamestate.GameState;
import com.me.coopapp.gamestate.GameStateItem;

public class Disposer implements IDisposer {
	
	private GameStateItem item;
	private ArrayList<GameStateItem> items;
	
	public Disposer(GameStateItem itemToDispose) {
		this.item = itemToDispose;
	}

	@Override
	public void dispose() {
		disposeItem(item);
	}
	
	private void disposeItem(GameStateItem itemToDispose) {
		if(itemToDispose.glContext != null) {
			Actor actor = itemToDispose.glContext.getIGdxActor().get();
			actor.remove();
		}
		GameState.get().items.remove(itemToDispose.hashCode());
	}
	
	public void AddItemToDispose(GameStateItem _itemToDispose) {
		
		items = items == null ? new ArrayList<GameStateItem>() : items;
		
		items.add(_itemToDispose);
	}

	@Override
	public void disposeGroup() {
		for(GameStateItem groupItem : GameState.get().items.values()) {
			if(groupItem.screen == item.screen && groupItem.hashCode() != item.hashCode()) {
				disposeItem(groupItem);
			}
		}
		
		dispose();
		
	}

}
