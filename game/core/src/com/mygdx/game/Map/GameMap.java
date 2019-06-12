package com.mygdx.game.Map;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;

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

    public boolean doesRectCollideWithMap(float x, float y, int width, int height) {
        if (x < 0 || y < 0 || x + width > getPixelWidth() || y + height > getPixelHeight())
            return true;

        for (int row = (int) (y / TileType.TILE_SIZE); row < Math.ceil((y + height) / TileType.TILE_SIZE); row++) {
            for (int col = (int) (x / TileType.TILE_SIZE); col < Math.ceil((x + width) / TileType.TILE_SIZE); col++) {
                for (int layer = 0; layer < getLayers(); layer++) {
                    TileType type = getTileTypeByCoordinates(layer, col, row);
                    if (type != null && type.isCollidable())
                        return true;
                }
            }
        }

        return false;
    }

    public boolean doesCollide(Rectangle rect){
        return doesRectCollideWithMap(rect.getX(), rect.getY(), (int)rect.getWidth(), (int)rect.getHeight());
    }
    public int getPixelWidth() {
        return this.getWidth() * TileType.TILE_SIZE;
    }

    public int getPixelHeight() {
        return this.getHeight() * TileType.TILE_SIZE;
    }


}
