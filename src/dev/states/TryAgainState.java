package dev.states;

import dev.Handler;
import dev.World;
import dev.graphics.Assets;

import java.awt.*;

public class TryAgainState extends State {
    public TryAgainState(Handler handler) {
        super(handler);
    }

    @Override
    public void tick() {
        handler.getWorld().getEntityManager().clearEntities();

        if(handler.getControl().play)
            State.setState(handler.getGame().gameState);
    }

    @Override
    public void render(Graphics g) {
        handler.getWorld().render(g);

        g.drawImage(Assets.tryAgain, 0, 190, null);
    }
}
