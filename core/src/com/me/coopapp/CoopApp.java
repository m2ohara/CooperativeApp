package com.me.coopapp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.sqlite.SQLiteConnection;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.me.coopapp.gamestate.GameState;

public class CoopApp extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	private GameLogic processor = GameLogic.getInstance();
	public SQLiteConnection connection;
	
	//TO DO: resolve connection dependency
	public void SetConnection(Connection conn) {
		connection = (SQLiteConnection)conn;
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		
		ScreenState.getScreenInstance().set(Types.ScreenTypes.startTexture);
		
		processor = GameLogic.getInstance();	
		//TODO: Resolve Set db connection
		processor.SetConnection(connection);
		SQLConnection.connection = connection;
		try {
			SQLConnection.metaData = connection.getMetaData();
		}
		catch(SQLException e) {
			
		}
		processor.processSetup();
		
		//Start logic thread
		new Thread(processor).start();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//Render process dependent objects
		processor.processScreenState();

		
		GameState.stage.draw();
		
		batch.begin();
//		batch.draw(ScreenState.getScreenInstance().texture, ScreenState.getScreenInstance().x, ScreenState.getScreenInstance().y);
		batch.end();
	}
	
	public void dispose() {
		if(processor != null) {
			processor.dispose();
		}
	}
}
