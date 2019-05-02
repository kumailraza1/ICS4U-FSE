package com.mygdx.game.Entities;

public class EntityType {
    private String name;
    private int health;
    private int damage;
    public EntityType(String typeName, int typeHealth, int typeDamage){
        typeName = name;
        typeHealth = health;
        typeDamage = damage;
    }
    public int getDamage(){
        return damage;
    }
    public int getMaxHealth(){
        return health;
    }
    public String getType(){
        return name;
    }
}
