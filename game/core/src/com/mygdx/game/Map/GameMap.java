package com.mygdx.game.Map;

import com.badlogic.gdx.graphics.OrthographicCamera;

public abstract class GameMap {
    public abstract void render (OrthographicCamera camera);
    public abstract void update (float delta);
    public abstract void dispose ();

    public abstract int getHeight();
    public abstract int getWidth();
    public abstract int getLayers();


    public TileType getTileTypeByLocation(int layer, float x, float y) { //returns pixel tile
        return this.getTileTypeByCoordinates(layer, (int) (x / TileType.TILE_SIZE), (int) (y / TileType.TILE_SIZE));
    }

    public abstract TileType getTileTypeByCoordinates(int layer, int col, int row); //returns tile at specified coordinates

}
