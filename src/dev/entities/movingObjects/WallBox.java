package dev.entities.movingObjects;

import dev.Handler;
import dev.graphics.Assets;

import java.awt.*;

public class WallBox extends Box {

    public WallBox(Handler handler, int x, int y) {

        super(handler, x, y);
        boxType = 5;
    }

    @Override
    public boolean isSolid() {

        return true;
    }

    @Override
    public int getBoxType() {

        return boxType;
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
    }
}
