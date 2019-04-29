package dev.entities;

import dev.Game;
import dev.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {

    public static final int DEFAULT_HEALTH = 2;
    protected Handler handler;
    protected float x;
    protected float y;
    protected Rectangle bounds;
    protected boolean active = true;
    protected int health;
    //    protected int vx;
    //    protected int vy;
    //    protected int angle;
    //    private BufferedImage img;

    public Entity(Handler handler, float x, float y){
        this.handler = handler;
        this.x = x;
        this.y = y;
        health = DEFAULT_HEALTH;

        bounds = new Rectangle(0, 0, 64, 64);
    }

    //    public Entity(Handler handler, float x, float y, int vx, int vy, int angle){
    //        this.handler = handler;
    //        this.x = x;
    //        this.y = y;
    //        this.vx = vx;
    //        this.vy = vy;
    //        this.angle = angle;
    //
    //        bounds = new Rectangle(0, 0, 64, 64);
    //        //        this.img = img;
    //    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract void die();


    public void hurt(int amount){
        health -= amount;
        if(health <= 0){
            active = false;
            die();
        }
    }

    public boolean checkEntityCollisions(float xOffset, float yOffset){
        for (Entity e : handler.getWorld().getEntityManager().getEntities()){
            if (e.equals(this))
                continue;

            if (e.getCollisionBounds(0,0).intersects(getCollisionBounds(xOffset,yOffset)))
                return true;
        }
        return false;
    }

    public Rectangle getCollisionBounds(float xOffset, float yOffset){
        return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset),
                bounds.width, bounds.height);
    }

    public Entity getEntityCollided(float xOffset, float yOffset){
        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if (e.equals(this))
                continue;
            if (e.getCollisionBounds(0,0).intersects(getCollisionBounds(xOffset, yOffset)))
                return e;
        }

        return null;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
