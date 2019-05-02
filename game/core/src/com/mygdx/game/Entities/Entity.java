package com.mygdx.game.Entities;

public abstract class Entity {
    private double xAcceleration, yAcceleration, xVelocity, yVelocity, xPosition, yPosition; //movement components
    private EntityType type;
    private double mass;

    private int hp;
    private int damage;

    public Entity(double xPos, double yPos, EntityType entityType){
        hp = entityType.getMaxHealth();
        damage = entityType.getDamage();
    }
    public void applyForces(){ //apply forces to the entity
        xVelocity += xAcceleration;
        yVelocity += yAcceleration;
        xPosition += xVelocity;
        yPosition += yVelocity;
    }
    public double getxAcceleration(){
        return xAcceleration;
    }
    public void setxAcceleration(double input){
        xAcceleration = input;
    }
    public double getyAcceleration(){
        return yAcceleration;
    }
    public void setyAcceleration(double input){
        yAcceleration = input;
    }
    public double getxVelocity(){
        return xVelocity;
    }
    public void setxVelocity(double input){
        xVelocity = input;
    }
    public double getyVelocity(){
        return yVelocity;
    }
    public void setyVelocity(double input){
        yVelocity = input;
    }
    public double getY(){
        return yPosition;
    }
    public double getX(){
        return xPosition;
    }
    public EntityType getType(){
        return type;
    }
    public int getDamage(){
        return damage;
    }
    public int getHP(){
        return hp;
    }
}
