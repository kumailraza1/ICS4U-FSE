package com.mygdx.game.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Map.GameMap;
import org.w3c.dom.Entity;

class Player extends Entity {
    private Texture img;
    @Override
    public void create (Vector2 pos, EntityType type, GameMap map) {
        super.create(pos, type, map);
        img = new Texture("player.png");
        //spawnRadius = snapshot.getFloat("spawnRadius", 50);
    }
}
