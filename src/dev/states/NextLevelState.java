package dev.states;

import dev.Handler;
import dev.graphics.Assets;

import java.awt.*;

public class NextLevelState extends State {
    public NextLevelState(Handler handler) {
        super(handler);
    }

    @Override
    public void tick() {
        if(handler.getControl().play) {
            State.setState(handler.getGame().gameState);
            ((GameState) State.getState()).nextLevel();
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.level2, 210, 200, null);
    }
}
