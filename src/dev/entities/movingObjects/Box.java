/**************************************
 * Abstract class for Boxes; all boxes (except walls)
 * can die, are solid, can crush or be crushed,
 * fall straight down, change fall speed, tick
 * and render.
 *
 * All boxes have a box type to determine weight.
 *
 * Extends moving object.
 *
 * Access to class provided by handler for most part.
 ************************************ */

package dev.entities.movingObjects;

import dev.Handler;

import java.awt.*;

public abstract class Box extends MovingObject {

    protected int boxType;

    // Timer to control boxes falling
    private long lastFallTimer;
    private long fallCoolDown = 500;
    private long fallTimer = fallCoolDown;

    public Box(Handler handler, int x, int y) {

        super(handler, x, y);
        boxType = 0;
        // set speed boxes fall based on level number
        setFallCoolDown(handler.getGame().getLevelNum());
    }

    public abstract boolean isSolid();

    public abstract int getBoxType();

    // when a box 'dies', it is removed from entity manager array
    @Override
    public void die() {
        handler.getWorld().getEntityManager().removeEntity(this);
    }

    // check to see if box below falling box is lighter or heavier
    // based on box type. higher value crushes smaller value
    public boolean crush(int vx, int vy) {
        if (this.getBoxType() > getEntityCollided(vx, vy).getBoxType())
            return true;

        return false;
    }

    // method controlling downward movement of boxes
    private void moveFall() {
        // get boxes to fall with a block-by-block movement
        // due to timer setup
        // speed of boxes changes with level advancement by
        // increasing fallCoolDown
        fallTimer += System.currentTimeMillis() - lastFallTimer;
        lastFallTimer = System.currentTimeMillis();
        if (fallTimer < fallCoolDown)
            return;

        // i could have left out vx, but it's an artifact from tank game
        vy = 40;
        vx = 0;

        // if the box does not collide with anything, allow movement
        if (!checkEntityCollisions(vx, vy)) {
            x += vx;
            y += vy;
        }

        // if colliding with a box, check for crushing
        else if (getEntityCollided(vx, vy) instanceof Box) {
            if (crush(vx, vy))
                // if crushed by falling box, remove entity in collision zone
                handler.getWorld().getEntityManager().removeEntity(getEntityCollided(vx, vy));
        }

        // if colliding with a player, hurt the player
        else if (getEntityCollided(vx, vy) instanceof Player) {
            handler.getWorld().getEntityManager().getPlayer().hurt(1);
        }

        // reset fallTimer
        fallTimer = 0;
    }


    // allows speed of boxes to increase
    public void setFallCoolDown(int factor) {
        fallCoolDown = fallCoolDown - (100 * factor);

    }

    // when ticking, call moveFall()
    @Override
    public void tick() {
        moveFall();
    }

    // abstract Box will not render
    @Override
    public void render(Graphics g) {

    }
}
