/* ****************************
All states have a handler, tick, and render.
****************************** */

package dev.states;

import dev.Game;
import dev.Handler;

import java.awt.Graphics;

public abstract class State {
    protected Handler handler;
    private static State currentState = null;

    public static void setState(State state){
        currentState = state;
    }

    public static State getState(){
        return currentState;
    }

    public State(Handler handler){
        this.handler = handler;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
}
