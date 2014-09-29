package com.me.coopapp;

import java.sql.Connection;
import java.util.ArrayList;

import org.sqlite.SQLiteConnection;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CoopApp extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	private ProcessManager process = ProcessManager.getProcessManager();
	public SQLiteConnection connection;
	
	//TO DO: resolve connection dependency
	public void SetConnection(Connection conn) {
		connection = (SQLiteConnection)conn;
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		
		process = ProcessManager.getProcessManager();	
		process.SetConnection(connection);
		process.Setup();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		process.ScreenState(batch);
		batch.end();
	}
}
