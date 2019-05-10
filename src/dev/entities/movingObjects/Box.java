package dev.entities.movingObjects;

import dev.Handler;

import java.awt.*;

public class Box extends MovingObject {

    protected int boxType;

    public Box(Handler handler, float x, float y) {

        super(handler, x, y);
    }

    public boolean isSolid(){

        return true;
    }

    public int getBoxType(){

        return 0;
    }

    @Override
    public void tick() {
        moveFall();
    }

    @Override
    public void render(Graphics g) {

    }
}
