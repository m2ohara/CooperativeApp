package com.me.coopapp.gamestate;

public class GdxDisposer {
	
	private GameStateItem itemToDispose;
	
	
	public GdxDisposer(GdxGameStateItem item) {
		
		itemToDispose = item;
		
		item.glContext.setDisposer(this);
		
	}
	
	public void dispose() {
		((IGLContext)itemToDispose.item).disposeGdx();
		itemToDispose.disposeGSItem();
	}
	
//	private void disposeGameStateItem() {
//		itemToDispose.state = NextThreadAction.FINISHED;
//		itemToDispose.disposeGSItem();
//	}
//	
//	private void disposeGdxItems() {
//		if(gdxItemsToDispose != null) {
//			Iterator<Disposable> it = gdxItemsToDispose.iterator();
//			while(it.hasNext()) {
//				it.next().dispose();
//			}
//		}
//	}

}
