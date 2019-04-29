package dev.states;

import dev.states.State;
import dev.Game;
import dev.Handler;
import dev.graphics.Assets;

import java.awt.*;

public class IntroState extends State{
    public IntroState(Handler handler){
        super(handler);
    }

    @Override
    public void tick() {
        if(handler.getControl().play)
            State.setState(handler.getGame().gameState);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.intro, 0, 0, null);
    }
}
