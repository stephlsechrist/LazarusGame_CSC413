/* **************************************
* Entites are game objects, static or moving.
* They all have collision bounds defined by
* a rectangle. All entities are 40x40 pixels.
 ************************************** */

package dev.entities;

import dev.Handler;

import java.awt.*;

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

    // checks each entity in the Entity array to see if it intersects with
    // this object based on collision rectangles of this object and
    // checked object
    public boolean checkEntityCollisions(int xOffset, int yOffset){
        for (Entity e : handler.getWorld().getEntityManager().getEntities()){
            if (e.equals(this))
                continue;

            if (e.getCollisionBounds(0,0).intersects(getCollisionBounds(xOffset,yOffset)))
                return true;
        }
        return false;
    }

    // returns Rectangle at x coordinate determined by current x and xoffset,
    // at y cooridnate determined by current y and yoffset,
    // of 40 x 40 dimension
    // basically returns rectangle surrounding object at specified location
    public Rectangle getCollisionBounds(int xOffset, int yOffset){
        return new Rectangle((x + bounds.x + xOffset), (y + bounds.y + yOffset),
                bounds.width, bounds.height);
    }

    // return Entity whose rectangle is intersecting with this object's rectangle
    // otherwise, return null
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

    // leftover from tank game

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
