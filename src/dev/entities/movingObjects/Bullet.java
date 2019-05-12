//package dev.entities.movingObjects;
//
//import dev.entities.movingObjects.MovingObject;
//import dev.Handler;
//import dev.graphics.Assets;
//import dev.input.PlayerControl;
//import dev.input.PlayerControl;
//
//import java.awt.*;
//import java.awt.geom.AffineTransform;
//
//public class Bullet extends MovingObject {
//
//    //    private final int R = 4;
//    private final int ROTATION_SPEED = 4;
//
//    private PlayerControl control;
//
//    // attack timer
//    // might not need these 3 statements; bullets hurt upon collision
//    private long lastAttackTimer;
//    private long attackCooldown = 400;
//    private long attackTimer = attackCooldown;
//
//    public Bullet(Handler handler, float x, float y, int vx, int vy, int angle) {
//        super(handler, x, y);
//        health = 1;
//        speed = DEFAULT_SPEED + 4;
//
//        bounds.x = 24;
//        bounds.y = 27;
//        bounds.width = 16;
//        bounds.height = 16;
//        this.vx = vx;
//        this.vy = vy;
//    }
//
//    public Bullet(Handler handler, float x, float y, int angle){
//        super(handler, x, y);
//        bounds.x = 24;
//        bounds.y = 27;
//        bounds.width = 16;
//        bounds.height = 16;
//
//        speed = DEFAULT_SPEED + 4;
//    }
//
//    @Override
//    public void tick() {
//        //        getInput();
////        moveForwards();
////        moveForwards();
////        if(checkEntityCollisions(vx, vy)) {
////            if (getEntityCollided((float) vx, (float) vy) instanceof Box || getEntityCollided((float) vx, (float) vy) instanceof Tank ||
////                    getEntityCollided((float) vx, (float) vy) instanceof Bullet) {
////                getEntityCollided((float) vx, (float) vy).hurt(1);
////            }
////            else if (getEntityCollided((float) vx, (float) vy) instanceof LifeBoost) {
////                x += vx;
////                y += vy;
////                return;
////            }
////            handler.getWorld().getEntityManager().removeEntity((this));
//
//
////        }
//    }
//
//    @Override
//    public void render(Graphics g) {
////        AffineTransform rotation = AffineTransform.getTranslateInstance((x - handler.getGameCam().getxOffset()), (y - handler.getGameCam().getyOffset()));
////        rotation.rotate(Math.toRadians(angle), Assets.bullet.getWidth() / 2.0, Assets.bullet.getHeight() / 2.0);
////        Graphics2D g2d = (Graphics2D) g;
////        // drawImage() from Graphics2D:
////        // drawImage(Image img, AffineTransform xform, ImageObserver obs)
////        g2d.drawImage(Assets.bullet, rotation, null);
////        //        g.setColor(Color.white);
//        //        g.drawRect((int) (x + bounds.x - handler.getGameCam().getxOffset()),
//        //                (int) (y + bounds.y - 4 - handler.getGameCam().getyOffset()),
//        //                bounds.width, bounds.height);
//    }
//
//
//    @Override
//    public void die() {
//
//    }
//
//    public int getHeight(){
//        return bounds.height;
//    }
//
//    public float getvx(){
//        return vx;
//    }
//
//    public float getvy(){
//        return vy;
//    }
//}