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
        if (handler.getControl().exit)
            System.exit(0);
    }

    @Override
    public void render(Graphics g) {
        handler.getWorld().render(g);

        if (handler.getGame().getLevelNum() == 3 && !(handler.getWorld().getEntityManager().getPlayer().getDeadStatus()))
            g.drawImage(Assets.win, 0, 190, null);
        else
            g.drawImage(Assets.end, 210, 200, null);

    }
}
