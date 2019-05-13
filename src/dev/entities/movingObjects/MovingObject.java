package dev.entities.movingObjects;

import dev.Handler;
import dev.entities.Entity;

import java.util.Random;

public abstract class MovingObject extends Entity {

    //    public static final float DEFAULT_SPEED = 3.0f;

    protected float speed;
    protected int vx, vy, angle;

    protected final int DEFAULT_SPEED = 6;
    private final int ROTATION_SPEED = 4;
    private long lastAttackTimer;
    private long attackCooldown = 1000;
    private long attackTimer = attackCooldown;

    private long lastMoveTimer;
    private long moveCoolDown = 300;
    private long moveTimer = moveCoolDown;

//    private long lastFallTimer;
//    private long fallCoolDown = 600;
//    private long fallTimer = fallCoolDown;

    //    public MovingObject(Handler handler, float x, float y, int vx, int vy, int angle){
    //        super(handler, x, y);
    //        this.vx = vx;
    //        this.vy = vy;
    //        this.angle = angle;
    //        speed = DEFAULT_SPEED;
    //    }

    public MovingObject(Handler handler, int x, int y){
        super(handler, x, y);
        speed = DEFAULT_SPEED;
        health = DEFAULT_HEALTH;

    }

    public void rotateLeft() {
        moveTimer += System.currentTimeMillis() - lastMoveTimer;
        lastMoveTimer = System.currentTimeMillis();
        if(moveTimer < moveCoolDown)
            return;

        if (!checkEntityCollisions(-40, 0))
            x-= 40;

        if (checkEntityCollisions(-40, 0) && !(getEntityCollided(-40, 0) instanceof WallBox)){
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

        if (!checkEntityCollisions(40, 0))
            x+= 40;

        if (checkEntityCollisions(40, 0) && !(getEntityCollided(40, 0) instanceof WallBox)){
            if (getEntityCollided(40, 0) instanceof Box){
                if (!checkEntityCollisions(40, -40)) {
                    x += 40;
                    y -= 40;
                }
            }
        }

        moveTimer = 0;

    }

//    public void moveFall(){
//        fallTimer += System.currentTimeMillis() - lastFallTimer;
//        lastFallTimer= System.currentTimeMillis();
//        if(fallTimer< fallCoolDown)
//            return;
//
//        vy = 40;
//        vx = 0;
//
//        handler.getWorld().getEntityManager().removeEntity(getEntityCollided(vx, vy));
//
//        if (!checkEntityCollisions(vx, vy)) {
//            if (!(getEntityCollided(vx, vy) instanceof Box)) {
//
//                x += vx;
//                y += vy;
//                //        if (checkEntityCollisions())
//            }
//
//            else if (getEntityCollided(vx, vy) instanceof Box){
////                Entity crusher = getEntityCollided(x, y);
////                EntittoCrush = ((Box) getEntityCollided(vx, vy)).getBoxType();
//
//                if (this.getBoxType() > getEntityCollided(vx, vy).getBoxType())
//                    System.out.println("crush!");
//            }
//        }
//        fallTimer = 0;
//    }

//    public void addNewBox(){
//
//        attackTimer += System.currentTimeMillis() - lastAttackTimer;
//        lastAttackTimer = System.currentTimeMillis();
//        if (attackTimer < attackCooldown)
//            return;
//
//        Random rand = new Random();
//        int newBoxNum = rand.nextInt(6) + 1;
//        System.out.println("new box number is " + newBoxNum);
//        CardboardBox cbox = new CardboardBox(handler, handler.getWorld().getEntityManager().getPlayer().getX(), 0);
//        handler.getWorld().getEntityManager().addEntity(cbox);
//        attackTimer = 0;
//    }

//    public void checkAttacks(){
//        attackTimer += System.currentTimeMillis() - lastAttackTimer;
//        lastAttackTimer = System.currentTimeMillis();
//        if(attackTimer < attackCooldown)
//            return;
//
//        vx = (int) Math.round(DEFAULT_SPEED * Math.cos(Math.toRadians(angle))) * 8 - 32;
//        vy = (int) Math.round(DEFAULT_SPEED * Math.sin(Math.toRadians(angle))) * 8;
//        Bullet b = new Bullet(handler, x + vx + 25, y + vy - 8, vx, vy, angle);
//        handler.getWorld().getEntityManager().addEntity(b);
//        attackTimer = 0;
//    }
//
//    // barrier walls do not have to be collidable because this function takes care of that
//    // if the x or y of the tank is beyond borders, adjust borders
//    public boolean checkBorder() {
//        if (x < 64) {
//            x = 64;
//            return true;
//        }
//
//        // stutters, but fix later
//        if (x >= 1856 - 64) {
//            x = 1856 - 65;
//            return true;
//        }
//        if (y < 64) {
//            y = 64;
//            return true;
//        }
//
//        // stutters, but fix later
//        if (y >= 1216 - 64) {
//            y = 1216 - 65;
//            return true;
//        }
//        return false;
//    }
//
//    protected boolean collisionWithTile(int x, int y){
//
//        return handler.getWorld().getTile(x, y).isSolid();
//    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
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
