/* ***************************************
* MovingObject is an abstract class that
* extends Entity. Player and boxes are moving
* entities.
 *************************************** */

package dev.entities.movingObjects;

import dev.Handler;
import dev.entities.Entity;

public abstract class MovingObject extends Entity {

    //    public static final float DEFAULT_SPEED = 3.0f;

    protected int vx, vy;


    // move timers used by player to have movement move
    // tile-by-tile. meant to use same variable for movement
    // of boxes, but forgot to go back and change.
    private long lastMoveTimer;
    private long moveCoolDown = 300;
    private long moveTimer = moveCoolDown;

    public MovingObject(Handler handler, int x, int y){
        super(handler, x, y);
        health = DEFAULT_HEALTH;
    }

    // name of method from tank game
    // this lets Lazarus move left
    // he automatically jumps on a box if possible
    // and he automatically jumps off of a box if possible
    public void rotateLeft() {
        moveTimer += System.currentTimeMillis() - lastMoveTimer;
        lastMoveTimer = System.currentTimeMillis();
        if(moveTimer < moveCoolDown)
            return;

        // if no collision, move left one tile
        if (!checkEntityCollisions(-40, 0))
            x-= 40;

        else if (checkEntityCollisions(-40, 0)){
            //if collides with box
            if (getEntityCollided(-40, 0) instanceof Box){
                // and if there isn't a box on top of that box, then jump left
                if (!checkEntityCollisions(-40, -40)) {
                    x -= 40;
                    y -= 40;
                }
            }
        }

        // reset move timer
        moveTimer = 0;
    }

    // name of method from tank game
    // this lets Lazarus move right
    // he automatically jumps on a box if possible
    // and he automatically jumps off of a box if possible
    public void rotateRight() {
        moveTimer += System.currentTimeMillis() - lastMoveTimer;
        lastMoveTimer = System.currentTimeMillis();
        if(moveTimer < moveCoolDown)
            return;

        // if no collision, move right
        if (!checkEntityCollisions(40, 0))
            x += 40;

        // if collision
        else if (checkEntityCollisions(40, 0)){
            // if collision with box
            if (getEntityCollided(40, 0) instanceof Box){
                // and no box on box, jump right
                if (!checkEntityCollisions(40, -40)) {
                    x += 40;
                    y -= 40;
                }
            }
        }

        // reset movement timer
        moveTimer = 0;
    }

    // getters and setters
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getvx() {
        return vx;
    }

    public void setvx(int vx) {
        this.vx = vx;
    }

    public int getvy() {
        return vy;
    }

    public void setvy (int vy) {
        this.vy = vy;
    }


    // die method not implemented for abstract class.
    @Override
    public void die() {

    }
}
