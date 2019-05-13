package dev.entities;

import dev.Game;
import dev.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {

    public static final int DEFAULT_HEALTH = 2;
    protected Handler handler;
    protected int x;
    protected int y;
    protected int boxType;
    protected Rectangle bounds;
    protected boolean active = true;
    protected int health;

    public Entity(Handler handler, int x, int y){
        this.handler = handler;
        this.x = x;
        this.y = y;
        health = DEFAULT_HEALTH;

        bounds = new Rectangle(0, 0, 40, 40);
    }

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

    public boolean checkEntityCollisions(int xOffset, int yOffset){
        for (Entity e : handler.getWorld().getEntityManager().getEntities()){
            if (e.equals(this))
                continue;

            if (e.getCollisionBounds(0,0).intersects(getCollisionBounds(xOffset,yOffset)))
                return true;
        }
        return false;
    }

    public Rectangle getCollisionBounds(int xOffset, int yOffset){
        return new Rectangle((x + bounds.x + xOffset), (y + bounds.y + yOffset),
                bounds.width, bounds.height);
    }

    public Entity getEntityCollided(int xOffset, int yOffset){
        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if (e.equals(this))
                continue;
            if (e.getCollisionBounds(0,0).intersects(getCollisionBounds(xOffset, yOffset)))
                return e;
        }

        return null;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getBoxType (){
        return boxType;
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
