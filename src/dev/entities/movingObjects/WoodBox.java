package dev.entities.movingObjects;

import dev.Handler;
import dev.graphics.Assets;

import java.awt.*;

public class WoodBox extends Box{
    public WoodBox(Handler handler, int x, int y) {

        super(handler, x, y);
        boxType = 2;
    }

    @Override
    public boolean isSolid(){

        return true;
    }

    @Override
    public int getBoxType() {
        return boxType;
    }

    @Override
    public void tick(){

        super.tick();
    }

    @Override
    public void render(Graphics g) {

        g.drawImage(Assets.woodBox, x, y, null);
    }
}
