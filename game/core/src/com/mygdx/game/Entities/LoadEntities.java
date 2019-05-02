package com.mygdx.game.Entities;
import java.util.ArrayList;

public class LoadEntities {
    private static ArrayList<Entity> current = new ArrayList<Entity>();
    public static ArrayList<Entity> LoadEntities(){
        return current;
    }
    public static ArrayList<Entity> getEntities(){
        return current;
    }
    public static void update(){
        for (Entity current : current){

        }
    }
}
