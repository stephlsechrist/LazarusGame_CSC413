package dev.entities.movingObjects;

import dev.Handler;
import dev.graphics.Assets;
import dev.input.PlayerControl;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Player extends MovingObject {

    //    private final int R = 4;
    private final int ROTATION_SPEED = 4;

    private PlayerControl control;
    private int tankNumber;
    private int lifeCount;

    // attack timer
    // might not need these 3 statements; bullets hurt upon collision
    //    private long lastAttackTimer;
    //    private long attackCooldown = 400;
    //    private long attackTimer = attackCooldown;

    public Player(Handler handler, float x, float y) {
        //        super(handler, x, y, vx, vy, angle);
        super(handler, x, y);
        health = 5;

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 49;
        bounds.height = 50;
        lifeCount = 3;
    }

    @Override
    public void tick() {
        getInput();
        //        System.out.println(angle);
        //        System.out.println(x);
        //        move();
        //        checkAttacks();
        if(checkEntityCollisions(vx, vy)){
            if(getEntityCollided((float) vx, (float) vy) instanceof Box){
                System.out.println("Ran into Box, do something");

//                handler.getWorld().getEntityManager().removeEntity(getEntityCollided((float) vx, (float) vy));
//                lifeCount++;
            }
            //            if(getEntityCollided((float) vx, (float) vy) instanceof DamageBoost){
            //                handler.getWorld().getEntityManager().removeEntity(getEntityCollided((float) vx, (float) vy));
            //            }
        }
    }

    @Override
    public void render(Graphics g) {
//        AffineTransform rotation = AffineTransform.getTranslateInstance((x-handler.getGameCam().getxOffset()), (y - handler.getGameCam().getyOffset()));
//        rotation.rotate(Math.toRadians(angle), Assets.tank.getWidth() / 2.0, Assets.tank.getHeight() / 2.0);
//        Graphics2D g2d = (Graphics2D) g;
        // drawImage() from Graphics2D:
        // drawImage(Image img, AffineTransform xform, ImageObserver obs)
//        g2d.drawImage(Assets.tank, rotation, null);
        //        g.setColor(Color.white);
        //        g.drawRect((int) (x + bounds.x - handler.getGameCam().getxOffset()),
        //                (int) (y + bounds.y - handler.getGameCam().getyOffset()),
        //                bounds.width, bounds.height);
//
//
//        g.setColor(Color.ORANGE);
//        for (int i = 0; i < lifeCount; i++) {
//            g.fillOval((int) (x + (i * 15) - handler.getGameCam().getxOffset()),
//                    (int) (y + bounds.y - 12 - handler.getGameCam().getyOffset()),
//                    12, 12);
//        }
//        g.setColor(Color.blue);
//        g.fillRect((int)(x - handler.getGameCam().getxOffset()),
//                (int) (y + 70 +  - handler.getGameCam().getyOffset()),
//                10 * health, 10);

        g.drawImage(Assets.player, (int) x, (int) y, null);
    }

    private void getInput(){
        //        vx = 0;
        //        vy = 0;

            if (handler.getControl().left) {
                this.rotateLeft();
            }
            if (handler.getControl().right) {
                this.rotateRight();
            }
            //            if (handler.getTankControl1().checkEntities)
            //            {
            //                handler.getWorld().getEntityManager().printContents();
            //            }
    }

    @Override
    public void die() {
        lifeCount--;
        health = 1;
            x = handler.getWorld().getSpawnX1();
            y = handler.getWorld().getSpawnY1();
        if (lifeCount == 0) {
            handler.getWorld().getEntityManager().removeEntity(this);
            handler.getGame().setState(handler.getGame().overState);
        }
    }
    //
    //    private void rotateLeft() {
    //        this.angle -= this.ROTATION_SPEED;
    //    }
    //
    //    private void rotateRight() {
    //        this.angle += this.ROTATION_SPEED;
    //    }
}
