package com.mygdx.game.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Map.GameMap;

import java.util.ArrayList;

public class Player{
    public static Entity player; //the player entity
    public static Texture currentTexture; //stores the texture that is currently being drawn to the screen
    private static ArrayList<Texture> textures = new ArrayList<Texture>(); //stores all of the textures used for the player
    public static void create(GameMap map){
        player = new com.mygdx.game.Entities.Entity(LoadTypes.types.get(0), new Vector2(5,5), map);
        textures = player.getType().textures;
        currentTexture = textures.get(0);
    }
    public static void render (SpriteBatch batch){
        batch.draw(currentTexture, player.getX(),player.getY());
    }
    public static void update(){
        player.updatePos(); //updates the position of the player based on the current velocity
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)){ //get movement input
            player.setxVelocity(-5);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)){
            player.setxVelocity(5);
        }
        else{
            player.setxVelocity(0);
        }
    }
    public Rectangle getBoundingRectangle(){ //returns the rectangle bounding the sprite currently
        Rectangle temp = new Rectangle(player.getX(), player.getY(), currentTexture.getWidth(), currentTexture.getHeight());
        return temp;
    }

}

/*class Player extends Entity {
    private Texture img;
    @Override
    public void create (Vector2 pos, EntityType type, GameMap map) {
        super.create(pos, type, map);
        img = new Texture("player.png");
        //spawnRadius = snapshot.getFloat("spawnRadius", 50);
    }
}*/
