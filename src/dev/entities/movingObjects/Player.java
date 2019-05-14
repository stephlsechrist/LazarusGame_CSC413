package dev.entities.movingObjects;

import dev.Handler;
import dev.entities.statics.StopButton;
import dev.graphics.Assets;
import dev.input.PlayerControl;
import dev.states.State;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Random;

public class Player extends MovingObject {


    private PlayerControl control;
    private int lifeCount;

    Random rand = new Random();
    private int nextBox;

    private long lastAttackTimer;
    private long attackCooldown = 1000 * 5;
    private long attackTimer = attackCooldown;

    public Player(Handler handler, int x, int y) {
        super(handler, x, y);
        health = 1;

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 40;
        bounds.height = 40;
        lifeCount = 3;
        // generate random number between 1 & 4 to new box of different types
        nextBox = rand.nextInt(100) % 4 + 1;
    }

    // as of right now, randomly chosen box added to level
    // may change to be specific boxes added to make sure player can actually win
    public void addNewBox(){

        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if (attackTimer < attackCooldown)
            return;

        // generate random number between 1 & 4 to new box of different types
        int newBoxNum = nextBox;
        nextBox = rand.nextInt(100) % 4 + 1;

        if (handler.getWorld().getEntityManager().getPlayer().getX() >= 120 &&
                handler.getWorld().getEntityManager().getPlayer().getX() < 560) {
            if (newBoxNum == 1) {
                CardboardBox cbox = new CardboardBox(handler, handler.getWorld().getEntityManager().getPlayer().getX(), -40);
                handler.getWorld().getEntityManager().addEntity(cbox);
            }
            if (newBoxNum == 2) {
                WoodBox wbox = new WoodBox(handler, handler.getWorld().getEntityManager().getPlayer().getX(), -40);
                handler.getWorld().getEntityManager().addEntity(wbox);
            }
            if (newBoxNum == 3) {
                MetalBox mbox = new MetalBox(handler, handler.getWorld().getEntityManager().getPlayer().getX(), -40);
                handler.getWorld().getEntityManager().addEntity(mbox);
            }
            if (newBoxNum == 4) {
                StoneBox sbox = new StoneBox(handler, handler.getWorld().getEntityManager().getPlayer().getX(), -40);
                handler.getWorld().getEntityManager().addEntity(sbox);
            }
        }
        attackTimer = 0;
    }

    @Override
    public void tick() {
        getInput();
        addNewBox();

        if (!(getEntityCollided(0, 20) instanceof Box)){
            y += 40;
        }

        if (getEntityCollided(40, 0) instanceof StopButton || getEntityCollided(-40, 0) instanceof StopButton){
            System.out.println("you win!");
            handler.getGame().nextLevel();
//            handler.getGame().setState(handler.getGame().nextLevelState);
        }
    }

    @Override
    public void render(Graphics g) {
        // where I will put life count

        int xpos = 30;
        for (int i = 0; i < lifeCount; i++){
            g.drawImage(Assets.life, xpos, 360, null);
            xpos += 20;
        }


        if (nextBox == 1) {
            g.drawImage(Assets.cardboardBox, 560, 360, null);
        }
        if (nextBox == 2){
            g.drawImage(Assets.woodBox, 560, 360, null);
        }
        if (nextBox == 3){
            g.drawImage(Assets.metalBox, 560, 360, null);
        }
        if (nextBox == 4){
            g.drawImage(Assets.stoneBox, 560, 360, null);
        }

        g.drawImage(Assets.player, x, y, null);
    }

    private void getInput(){
            if (handler.getControl().left) {
                this.rotateLeft();
            }
            if (handler.getControl().right) {
                this.rotateRight();
            }

    }

    public int getLifeCount(){
        return lifeCount;
    }

    public void setLifeCount(int lifeCount){
        this.lifeCount = lifeCount;
    }

    @Override
    public void die() {
//        handler.getWorld().getEntityManager().removeEntity(this);
        lifeCount--;
        health = 1;
        x = handler.getWorld().getSpawnX1();
        y = handler.getWorld().getSpawnY1();

        if (lifeCount != 0) {
            handler.getWorld().getEntityManager().clearEntities();
//            handler.getWorld().worldReset();
            handler.getGame().setState(handler.getGame().tryAgainState);
//                        handler.getWorld().tryLevelAgain();
        }

        else if (lifeCount == 0) {
            handler.getGame().setState(handler.getGame().overState);
        }
    }
}
