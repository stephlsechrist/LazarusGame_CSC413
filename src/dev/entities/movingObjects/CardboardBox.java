/***********************************************
 * Cardboard box is lightest of boxes. Will be
 * crushed by any other box.
 **********************************************/

package dev.entities.movingObjects;

import dev.Handler;

import dev.graphics.Assets;

import java.awt.*;

public class CardboardBox extends Box{
    public CardboardBox(Handler handler, int x, int y) {

        super(handler, x, y);
        boxType = 1;
    }

    @Override
    public boolean isSolid(){
        return true;
    }

    @Override
    public int getBoxType() {
        return this.boxType;
    }

    // call moveFall()
    @Override
    public void tick(){
        super.tick();
    }

    // draw cardboard box above player coordinates
    public void render(Graphics g)
    {
        g.drawImage(Assets.cardboardBox, x, y, null);
    }
}
