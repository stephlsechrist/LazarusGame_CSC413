package dev.entities.movingObjects;

import dev.Handler;
import dev.entities.Entity;

import java.util.Random;

public abstract class MovingObject extends Entity {

    //    public static final float DEFAULT_SPEED = 3.0f;

    protected int vx, vy;

//    protected final int DEFAULT_SPEED = 6;

    private long lastMoveTimer;
    private long moveCoolDown = 300;
    private long moveTimer = moveCoolDown;

    public MovingObject(Handler handler, int x, int y){
        super(handler, x, y);
//        speed = DEFAULT_SPEED;
        health = DEFAULT_HEALTH;

    }

    public void rotateLeft() {
        moveTimer += System.currentTimeMillis() - lastMoveTimer;
        lastMoveTimer = System.currentTimeMillis();
        if(moveTimer < moveCoolDown)
            return;

        if (!checkEntityCollisions(-40, 0))
            x-= 40;

        else if (checkEntityCollisions(-40, 0) && !(getEntityCollided(-40, 0) instanceof WallBox)){
            if (getEntityCollided(-40, 0) instanceof Box){
                if (!checkEntityCollisions(-40, -40)) {
                    x -= 40;
                    y -= 40;
                }
            }
        }

        moveTimer = 0;
    }

    public void rotateRight() {
        moveTimer += System.currentTimeMillis() - lastMoveTimer;
        lastMoveTimer = System.currentTimeMillis();
        if(moveTimer < moveCoolDown)
            return;

        if (!checkEntityCollisions(40, 0)) {
            x += 40;

        }

        else if (checkEntityCollisions(40, 0) && !(getEntityCollided(40, 0) instanceof WallBox)){
            if (getEntityCollided(40, 0) instanceof Box){
                if (!checkEntityCollisions(40, -40)) {
                    x += 40;
                    y -= 40;
                }
            }
        }
        moveTimer = 0;
    }

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

    @Override
    public void die() {

    }
}
