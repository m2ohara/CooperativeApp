package com.me.coopapp.gamestate;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.utils.Disposable;
import com.me.coopapp.ui.GdxActor;

public class GdxDisposer {
	
	private GameStateItem itemToDispose;
	private ArrayList<GdxActor> gdxGSItemsToDispose;
	
	
	public GdxDisposer(GdxGameStateItem item) {
		
		itemToDispose = item;
		
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
		itemToDispose.disposeGSItem();
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
		Iterator<GameStateItem> it = GameState.get().items.iterator();
		while(it.hasNext()) {
			GameStateItem item = it.next();
			if(item.screen == itemToDispose.screen && !item.equals(itemToDispose)) {
				it.remove();
			}
		}
	}

}
