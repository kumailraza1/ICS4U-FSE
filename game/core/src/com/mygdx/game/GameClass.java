 package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Entities.LoadTypes;
import com.mygdx.game.Entities.Player;
import com.mygdx.game.Map.GameMap;
import com.mygdx.game.Map.TileType;
import com.mygdx.game.Map.TiledGameMap;

import java.awt.*;

 public class GameClass extends ApplicationAdapter {
	SpriteBatch batch;
	OrthographicCamera camera;
	GameMap gameMap;
	@Override
	public void create () {
        LoadTypes.load();
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.update();
		gameMap = new TiledGameMap();
        Player.create(gameMap);
	}

	@Override
	public void render () {
	    Player.update();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gameMap.render(camera);
		batch.begin();
		Player.render(batch);
		System.out.println(gameMap.doesCollide(Player.getBoundingRectangle()));
        TileType type = gameMap.getTileTypeByLocation(0, 10, 50);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
