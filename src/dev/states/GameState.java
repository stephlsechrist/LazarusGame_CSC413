package dev.states;

import dev.Handler;
import dev.World;

import java.awt.*;
import java.util.Map;

public class GameState extends State{
    private World world;
    private int levelNum = 0;
    private int lifeCount;

    public GameState(Handler handler){
        super(handler);
        world = new World(handler, "\\src\\resources\\world1.txt");
        handler.setWorld(world);
    }

    public void nextLevel(){
        lifeCount = handler.getWorld().getEntityManager().getPlayer().getLifeCount();
        world = new World(handler, "\\src\\resources\\world2.txt");
        handler.setWorld(world);
        levelNum++;
        handler.getWorld().getEntityManager().getPlayer().setLifeCount(lifeCount);
    }

    @Override
    public void tick(){
        world.tick();
    }

    @Override
    public void render(Graphics g){
        world.render(g);
    }
}
