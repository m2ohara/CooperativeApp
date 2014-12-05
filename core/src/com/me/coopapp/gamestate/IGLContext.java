package com.me.coopapp.gamestate;

import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Disposable;

public interface IGLContext {
	
	public void setDisposer(GdxDisposer disposer);
	
	public GdxDisposer getDisposer();

	public void instantiate();
	
	public void setToStage(Stage stage);
	
	public void disposeGdx();
	
	public ArrayList<Disposable> getDisposableGdx();
}
