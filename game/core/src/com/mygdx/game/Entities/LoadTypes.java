package com.mygdx.game.Entities;

import com.badlogic.gdx.graphics.Texture;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadTypes {
    public static ArrayList<EntityType> types = new ArrayList<EntityType>();
    public static void load() {
        try {
            Scanner inFile = new Scanner(new BufferedReader(new FileReader("types.txt")));
            int max = Integer.parseInt(inFile.nextLine());
            for (int i = 0; i < max; i++){
                String name = inFile.nextLine();
                int health = Integer.parseInt(inFile.nextLine());
                int damage = Integer.parseInt(inFile.nextLine());
                String[] split = inFile.nextLine().split(",");
                ArrayList<Texture> tempTex = new ArrayList<Texture>();
                for (int k = 0; k < Integer.parseInt(split[0]); k++){
                    tempTex.add(new Texture(split[k+1]));
                }
                types.add(new EntityType(name, health, damage, tempTex));
            }
        }
        catch(IOException ex){
            System.out.println("types.txt not found");
        }
    }
}
