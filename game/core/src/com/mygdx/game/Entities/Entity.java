package com.mygdx.game.Entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Map.GameMap;

public class Entity{
    public Entity (EntityType inputType, Vector2 position, GameMap currentMap){
        pos = position;
        type = inputType;
        map = currentMap;
        HP = type.getMaxHealth(); //set max HP
    }
    private Vector2 pos; //stores the current position of the entity
    private EntityType type; //the type of entity
        private double mass; //I might get rid of this, I might not have time to implement this
    private GameMap map; //the map that this entity is located on
    private int HP;

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public Vector2 getPos() {
        return pos;
    }

    public float getX(){
        return pos.x;
    }

    public void setX(float x){
        pos.x = x;
    }

    public void moveX(float x){
        pos.x += x;
    }

    public float getY(){
        return pos.y;
    }

    public void setY(float y){
        pos.y = y;
    }

    public void moveY(float y){
        pos.y += y;
    }

    public void setPos(Vector2 pos) {
        this.pos = pos;
    }

    public EntityType getType() {
        return type;
    }

    public void setType(EntityType type) {
        this.type = type;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public GameMap getMap() {
        return map;
    }

    public void setMap(GameMap map) {
        this.map = map;
    }
}
/*public abstract class Entity {
    private double xAcceleration, yAcceleration, xVelocity, yVelocity, xPosition, yPosition; //movement components
    private EntityType type;
    private double mass;
    private GameMap map;

    private int hp;
    private int damage;

    public void create (Vector2 position, EntityType type, GameMap map) {
        this.xPosition = position.x;
        this.yPosition = position.y;
        this.type = type;
        this.map = map;
    }
    public abstract void render (SpriteBatch batch);
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
}*/
