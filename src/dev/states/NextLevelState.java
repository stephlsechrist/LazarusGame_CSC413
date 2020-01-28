package dev.states;

import dev.Handler;
import dev.graphics.Assets;

import java.awt.*;
import java.nio.file.StandardOpenOption;

public class NextLevelState extends State {

    public NextLevelState(Handler handler)
    {
        super(handler);
    }

    @Override
    public void tick() {
        if(handler.getControl().play) {
            State.setState(handler.getGame().gameState);
            handler.getGame().nextLevel();
//            ((GameState) State.getState()).nextLevel();
        }
    }

    @Override
    public void render(Graphics g) {
        handler.getWorld().render(g);

        if (handler.getGame().getLevelNum() == 0)
            g.drawImage(Assets.level1, 0, 190, null);
        if (handler.getGame().getLevelNum() == 1)
            g.drawImage(Assets.level2, 0, 190, null);
        if (handler.getGame().getLevelNum() == 2)
            g.drawImage(Assets.level3, 0, 190, null);
        if (handler.getGame().getLevelNum() == 3)
            State.setState(handler.getGame().overState);
//            g.drawImage(Assets.win, 0, 190, null);
    }
}
