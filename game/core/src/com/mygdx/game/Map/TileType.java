package com.mygdx.game.Map;

import java.util.HashMap;

public enum TileType {
    DIRT(0,true,false),
    DANGEROUS(1,true, true),
    AIR(2, false, false);

    public static final int TILE_SIZE = 16;
    private int id;
    private boolean collidable;
    private boolean dangerous;

    private TileType(int identification, boolean collision, boolean causesDamage){
        identification = id;
        collidable = collision;
        dangerous = causesDamage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCollidable() {
        return collidable;
    }

    public void setCollidable(boolean collidable) {
        this.collidable = collidable;
    }

    public boolean isDangerous() {
        return dangerous;
    }

    public void setDangerous(boolean dangerous) {
        this.dangerous = dangerous;
    }
    private static HashMap<Integer, TileType> tileMap;

    static {
        tileMap = new HashMap<Integer, TileType>();
        for (TileType tileType : TileType.values()) {
            tileMap.put(tileType.getId(), tileType);
        }
    }

    public static TileType getTileTypeById (int id) {
        return tileMap.get(id);
    }
}
