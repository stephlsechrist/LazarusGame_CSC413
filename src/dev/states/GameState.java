package dev.states;

import dev.Game;
import dev.Handler;
import dev.entities.movingObjects.Player;
import dev.entities.statics.StopButton;
import dev.graphics.Assets;
import dev.input.PlayerControl;
import dev.tiles.Tile;
import dev.World;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class GameState extends State{
    private World world;

    public GameState(Handler handler){
        super(handler);
        world = new World(handler, "\\src\\resources\\world1.txt");
        handler.setWorld(world);
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
