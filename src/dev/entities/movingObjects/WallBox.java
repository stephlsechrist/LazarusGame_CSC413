/* **********************************
* Wall Box should actually have been a
* static entity, but I made it a moving
* object out of convenience and didn't have
* a chance to change it. Can't be crushed by
* any other box. Added to entity manager
* in loadWorld() method of World class
 ********************************** */
package dev.entities.movingObjects;

import dev.Handler;

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

    // doesn't tick
    @Override
    public void tick() {
    }

    // renders from loadWorld()
    @Override
    public void render(Graphics g) {
    }
}
