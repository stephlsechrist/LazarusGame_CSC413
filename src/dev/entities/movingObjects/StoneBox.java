/**************************************
 * Stone box is box type 4. Crushes all
 * other boxes.
************************************** */
package dev.entities.movingObjects;

import dev.Handler;
import dev.graphics.Assets;

import java.awt.*;

public class StoneBox extends Box {
    public StoneBox(Handler handler, int x, int y) {
        super(handler, x, y);
        boxType = 4;
    }

    @Override
    public boolean isSolid(){
        return true;
    }

    @Override
    public int getBoxType() {
        return boxType;
    }

    // call moveFall()
    @Override
    public void tick(){
        super.tick();
    }

    // draw Stone box
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.stoneBox, x, y, null);
    }
}
