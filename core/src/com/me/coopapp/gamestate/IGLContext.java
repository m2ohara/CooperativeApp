package com.me.coopapp.gamestate;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.me.coopapp.ui.IGdxActor;

public interface IGLContext {
	
//	public void setDisposer(GdxDisposer disposer);
//	
//	public GdxDisposer getDisposer();

	public void instantiate();
	
	public void setToStage(Stage stage);
	
	public IGdxActor getIGdxActor();
	
//	public void disposeGdx();
//	
//	public ArrayList<Disposable> getDisposableGdx();
}
