package dev.tiles;

import dev.graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    // STATIC STUFF HERE

    public static Tile[] tiles = new Tile[256];

    // create one instance of a tile and store in tiles array
    public static Tile noTile = new Tile(null, 0);
    public static Tile cardboardTile = new CardboardTile(Assets.cardboardBox, 1);
    public static Tile woodTile = new WoodTile(Assets.woodBox, 2);
    public static Tile metalTile = new MetalTile(Assets.metalBox, 3);
    public static Tile stoneTile = new StoneTile(Assets.stoneBox, 4);
    public static Tile wallTile = new WallTile(Assets.wall, 5);

    // CLASS
    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id;

        tiles[id] = this;
    }

    public void tick(){

    }

    public void render(Graphics g, int x, int y){
        g.drawImage(texture, x, y, null);
    }

    public boolean isSolid(){
        return false;
    }

    public int getId(){
        return id;
    }
}
