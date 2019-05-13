package dev.states;

import dev.Handler;
import dev.graphics.Assets;

import java.awt.*;

public class OverState extends State {
    public OverState(Handler handler) {
        super(handler);
    }

    @Override
    public void tick() {
        //        if(handler.getTankControl1().space)
        //            State.setState(handler.getGame().overState);
    }

    @Override
    public void render(Graphics g) {
        handler.getWorld().render(g);
        g.drawImage(Assets.end, 210, 200, null);
        if (handler.getControl().exit)
            System.exit(0);
    }
}
