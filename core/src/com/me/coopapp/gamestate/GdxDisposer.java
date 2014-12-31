package com.me.coopapp.gamestate;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.utils.Disposable;
import com.me.coopapp.gamestate.GameStateItem.NextThreadAction;
import com.me.coopapp.ui.GdxActor;

public class GdxDisposer {
	
	private GameStateItem itemToDispose;
	private ArrayList<GdxActor> gdxGSItemsToDispose;
	
	
	public GdxDisposer(GdxGameStateItem item) {
		
		itemToDispose = item;
		//Set related gdx item disposal 
		item.glContext.setDisposer(this);
		
	}
	
	public void addGdxItemToDispose(GdxActor itemToDispose) {
		
		gdxGSItemsToDispose = gdxGSItemsToDispose == null ? new ArrayList<GdxActor>() : gdxGSItemsToDispose;
		
		gdxGSItemsToDispose.add(itemToDispose);
	}
	
	public void addGdxItemToDispose(ArrayList<GdxActor> itemsToDispose) {
		
		gdxGSItemsToDispose = gdxGSItemsToDispose == null ? new ArrayList<GdxActor>() : gdxGSItemsToDispose;
		
		gdxGSItemsToDispose.addAll(itemsToDispose);
	}
	
	public void dispose() {
		((IGLContext)itemToDispose.item).disposeGdx();
//		itemToDispose.disposeGSItem();
		itemToDispose.state = NextThreadAction.DISPOSE;
	}
	
	public void disposeAll() {
		disposeGdxItems();
		disposeGlgItems();
		dispose();
	}
	
	private void disposeGdxItems() {
		if(gdxGSItemsToDispose != null) {
			Iterator<GdxActor> it = gdxGSItemsToDispose.iterator();
			//For every GdxActor
			while(it.hasNext()) {
				Iterator<Disposable> itDisp = it.next().getDisposableGdx().iterator();
				//For every GdxItem
				while(itDisp.hasNext()) {
					itDisp.next().dispose();
				}
			}
		}
	}
	
	private void disposeGlgItems() {
		
		for(GameStateItem item : GameState.get().items.values()) {
			//Dispose all other GameStateItems 
			if(item.screen == itemToDispose.screen && !item.equals(itemToDispose)) {
				item.state = NextThreadAction.DISPOSE;
			}
		}
	}

}
