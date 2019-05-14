package dev.states;

import dev.Handler;
import dev.World;
import dev.entities.movingObjects.Player;
import dev.graphics.Assets;

import java.awt.*;

public class TryAgainState extends State {
    private int lifeCount;
    private World world;
    private Player player;

    public TryAgainState(Handler handler) {
        super(handler);

    }

    public void tryLevelAgain(){
        lifeCount = handler.getWorld().getEntityManager().getPlayer().getLifeCount();
//        player = handler.getWorld().getEntityManager().getPlayer();
        world = new World(handler, "\\src\\resources\\world1.txt");
        handler.setWorld(world);
//        handler.getWorld().getEntityManager().setPlayer(player);
        handler.getWorld().getEntityManager().getPlayer().setLifeCount(lifeCount);
    }

    @Override
    public void tick() {
//        handler.getWorld().getEntityManager().clearEntities();
        handler.getWorld().getEntityManager().clearEntities();


        if(handler.getControl().play) {
            State.setState(handler.getGame().gameState);
        }
//        handler.getWorld().getEntityManager().getPlayer().setLifeCount(lifeCount);
    }

    @Override
    public void render(Graphics g) {
        handler.getWorld().render(g);

        g.drawImage(Assets.tryAgain, 0, 190, null);
    }
}
