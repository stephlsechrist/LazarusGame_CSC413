package dev;

import dev.Game;
import dev.input.PlayerControl;
import dev.World;

public class Handler {
    private Game game;
    private World world;

    public Handler(Game game){
        this.game = game;
    }

    public PlayerControl getControl(){
        return game.getControl();
    }

    public int getWidth(){
        return game.getWidth();
    }

    public int getHeight(){
        return game.getHeight();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
