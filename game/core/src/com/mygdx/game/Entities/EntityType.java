package com.mygdx.game.Entities;


import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class EntityType { //this class holds the type of entity - types such as different enemies, the player, etc.
    private String name; //the entity name
    private int health; //the max health it may have
    private int damage; //the amount of damage it can do
    public ArrayList<Texture> textures = new ArrayList<Texture>();
    public EntityType(String typeName, int typeHealth, int typeDamage, ArrayList<Texture> entityTextures){
        name = typeName;
        health = typeHealth;
        damage = typeDamage;
        textures.addAll(entityTextures);
    }
    public int getDamage(){
        return damage;
    }
    public int getMaxHealth(){
        return health;
    }
    public String getName(){
        return name;
    }
}
