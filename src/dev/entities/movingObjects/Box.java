package dev.entities.movingObjects;

import dev.Handler;

import java.awt.*;

public abstract class Box extends MovingObject {

    protected int boxType;

    private long lastFallTimer;
    private long fallCoolDown = 600;
    private long fallTimer = fallCoolDown;

    public Box(Handler handler, int x, int y) {

        super(handler, x, y);
        boxType = 0;
    }

    public abstract boolean isSolid();
    public abstract int getBoxType();

//    public int getBoxType(){
//        return 0;
//    }

    @Override
    public void die() {
        handler.getWorld().getEntityManager().removeEntity(this);
    }

    public boolean crush (int vx, int vy){
        if (this.getBoxType() > getEntityCollided(vx, vy).getBoxType())
            return true;

        return false;
    }

    public void moveFall(){
        fallTimer += System.currentTimeMillis() - lastFallTimer;
        lastFallTimer= System.currentTimeMillis();
        if(fallTimer< fallCoolDown)
            return;

        vy = 40;
        vx = 0;


        if (!checkEntityCollisions(vx, vy)) {
            x += vx;
            y += vy;
        }

        if (getEntityCollided(vx, vy) instanceof Box){
            if (crush(vx, vy))
                handler.getWorld().getEntityManager().removeEntity(getEntityCollided(vx, vy));
        }

        if (getEntityCollided(vx, vy) instanceof Player){
            handler.getWorld().getEntityManager().getPlayer().hurt(1);
        }


        fallTimer = 0;
    }

    @Override
    public void tick() {
        moveFall();
    }

    @Override
    public void render(Graphics g) {

    }
}
