package dev.entities.movingObjects;

import dev.Handler;
import dev.graphics.Assets;

import java.awt.*;

public class MetalBox extends Box {

    public MetalBox(Handler handler, int x, int y)
    {
        super(handler, x, y);
        boxType = 3;
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
    public void render(Graphics g){

        g.drawImage(Assets.metalBox, x, y, null);
    }
}
