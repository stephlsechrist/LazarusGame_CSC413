package dev.entities.movingObjects;

import dev.Handler;
import dev.graphics.Assets;

import java.awt.*;

public class WallBox extends Box {
    private int boxType = 5;

    public WallBox(Handler handler, float x, float y) {
        super(handler, x, y);
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
