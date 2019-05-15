package dev;

import dev.entities.EntityManager;
import dev.entities.movingObjects.Player;
import dev.entities.movingObjects.WallBox;
import dev.entities.statics.StopButton;
import dev.graphics.Assets;
import dev.states.State;
import dev.states.TryAgainState;
import dev.tiles.Tile;
import dev.utils.Utils;

import java.awt.*;

public class World {
    private Handler handler;
    private int width, height, spawnX1, spawnY1;
    private int lifeCount;
    private World world;
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

        entityManager.addEntity(new StopButton(handler, 40, 120));
        entityManager.addEntity(new StopButton(handler, 560, 120));
//        entityManager.addEntity(new NextBox(handler, 1000, 800));


        //        entityManager.addEntity(new DamageBoost(handler, 100, 800));
    }

    public void tick(){

        entityManager.tick();
    }

    // change this!
    public void render(Graphics g){
        g.drawImage(Assets.bg, 0, 0, null);

        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                if (tilePos[x][y] != 0) {
                    getTile(x, y).render(g, (x * 40), (y * 40));
                }
            }
        }
        g.setColor(Color.BLACK);
        // next box display background
        g.fillRect(540, 340, 80, 80);
        // life and level display background
        g.fillRect(20, 340, 80, 80);

        g.setFont(new Font("Helvetica", Font.BOLD, 12));
        g.setColor(Color.gray);
        g.drawString("Level " + String.valueOf(handler.getGame().getLevelNum()), 40, 400);

        entityManager.render(g);

    }

    public void tryLevelAgain(){
        if (State.getState() instanceof TryAgainState){
            ((TryAgainState) State.getState()).tryLevelAgain();
        }
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
                if(tilePos[x][y] == 5){
                        entityManager.addEntity(new WallBox(handler, (x * 40), (y * 40)));
                }
            }
        }
    }

//    public void worldReset(){
//        lifeCount = handler.getWorld().getEntityManager().getPlayer().getLifeCount();
//        world = new World(handler, "\\src\\resources\\world1.txt");
//        handler.setWorld(world);
//        handler.getWorld().getEntityManager().getPlayer().setLifeCount(lifeCount);
//        handler.getWorld().getEntityManager().clearEntities();
//    }

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