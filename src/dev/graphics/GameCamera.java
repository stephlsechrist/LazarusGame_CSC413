package dev.graphics;

import dev.Game;
import dev.Handler;
import dev.entities.Entity;

public class GameCamera {
    private float xOffset, yOffset;
    private Handler handler;

    public GameCamera(Handler handler, float xOffset, float yOffset){
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.handler = handler;
    }

    public void checkBlankSpace(){
        if (xOffset < 0) {
            xOffset = 0;
        } else if (xOffset > ((handler.getWorld().getWidth() * 64) - handler.getWidth())) {
            xOffset = ((handler.getWorld().getWidth() * 64) - handler.getWidth());
        }

        if (yOffset < 0) {
            yOffset = 0;
        } else if (yOffset > ((handler.getWorld().getHeight() * 64) - handler.getHeight())){
            yOffset = ((handler.getWorld().getHeight() * 64) - handler.getHeight());
        }

    }

    public void centerOnEntity(Entity e){
        xOffset = e.getX() - handler.getWidth() / 2;
        yOffset = e.getY() - handler.getHeight() / 2;
        checkBlankSpace();
    }

    public void move(float xAmt, float yAmt){
        xOffset += xAmt;
        yOffset += yAmt;
        checkBlankSpace();
    }

    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
        checkBlankSpace();
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
        checkBlankSpace();
    }
}
