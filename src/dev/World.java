package dev;

import dev.Handler;
import dev.entities.EntityManager;
import dev.entities.movingObjects.Player;
import dev.entities.statics.NextBox;
import dev.entities.statics.StopButton;
import dev.entities.statics.Wall;
import dev.graphics.Assets;
import dev.tiles.Tile;
import dev.utils.Utils;

import java.awt.*;

public class World {
    private Handler handler;
    private int width, height, spawnX1, spawnY1;
    private int[][] tilePos;

    // Entities
    private EntityManager entityManager;
    // Items


    public World(Handler handler, String path){
        this.handler = handler;
        entityManager = new EntityManager(handler, new Player(handler, 100, 100));

        loadWorld(path);
        //        entityManager.addEntity(new LifeBoost(handler, 100, 100));

        entityManager.getPlayer().setX(spawnX1);
        entityManager.getPlayer().setY(spawnY1);

//        entityManager.addEntity(new StopButton(handler, 250, 300));
//        entityManager.addEntity(new StopButton(handler, 600, 400));
//        entityManager.addEntity(new NextBox(handler, 1000, 800));

        //        entityManager.addEntity(new DamageBoost(handler, 100, 800));
    }

    public void tick(){

        entityManager.tick();
    }

    // change this!
    public void render(Graphics g){
//        int xStart = (int) Math.max(0, handler.getGameCam().getxOffset() / 64);
//        int xEnd = (int) Math.min(width, (handler.getGameCam().getxOffset() + handler.getWidth()) / 64 + 1);
//        int yStart = (int) Math.max(0, handler.getGameCam().getyOffset() / 64);
//        int yEnd = (int) Math.min(height, (handler.getGameCam().getyOffset() + handler.getHeight()) / 64 + 1);

        g.drawImage(Assets.bg, 0, 0, null);

        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                if (tilePos[x][y] != 0) {
                    getTile(x, y).render(g, (int) (x * 40), (int) (y * 40));
                }
            }
        }

        entityManager.render(g);
    }

    public Tile getTile(int x, int y){
        if (x < 0 || y < 0 || x >= width || y >= height)
            return Tile.noTile;

        Tile t = Tile.tiles[tilePos[x][y]];
        if (t == null){
            return Tile.noTile;
        }

        return t;
    }

    private void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        spawnX1 = Utils.parseInt(tokens[0]);
        spawnY1 = Utils.parseInt(tokens[1]);
        width = Utils.parseInt(tokens[2]);
        height = Utils.parseInt(tokens[3]);

        tilePos = new int[width][height];
        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                tilePos[x][y] = Utils.parseInt(tokens[(x+y * width) + 4]);
                if(tilePos[x][y] == 1){
                    entityManager.addEntity(new Wall(handler, (float) (x * 40), (float) (y * 40)));
                }
            }
        }
    }

    public void setTileArray(int x, int y, int newID){
        this.tilePos[x][y] = newID;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
    public int getSpawnX1() {
        return spawnX1;
    }

    public void setSpawnX1(int spawnX1) {
        this.spawnX1 = spawnX1;
    }

    public int getSpawnY1() {
        return spawnY1;
    }

    public void setSpawnY1(int spawnY1) {
        this.spawnY1 = spawnY1;
    }
}