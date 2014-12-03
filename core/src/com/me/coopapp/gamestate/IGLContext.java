package com.me.coopapp.gamestate;

import com.badlogic.gdx.scenes.scene2d.Stage;

public interface IGLContext {
	
	public void setDisposer(GdxDisposer disposer);

	public void instantiate();
	
	public void setToStage(Stage stage);
	
	public void dispose();
}
