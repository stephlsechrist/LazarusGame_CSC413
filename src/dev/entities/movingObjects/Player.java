/* *******************************
* Player is a MovingObject.
* Here is where boxes are randomly
* added to the game.
 */

package dev.entities.movingObjects;

import dev.Handler;
import dev.entities.statics.StopButton;
import dev.graphics.Assets;
import dev.input.PlayerControl;

import java.awt.*;
import java.util.Random;

public class Player extends MovingObject {
    private int lifeCount;
    private boolean isDead;

    // used to randomly generate boxes
    Random rand = new Random();
    private int nextBox;

    private long lastAttackTimer;
    private long attackCooldown = 1000 * 4;
    private long attackTimer = attackCooldown;

    public Player(Handler handler, int x, int y) {
        super(handler, x, y);
        // player automatically loses a life with one hit (squish)
        health = 1;

        // to draw collision bounds
        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 40;
        bounds.height = 40;

        lifeCount = 3;
        // generate random number between 1 & 4 to new box of different types
        nextBox = rand.nextInt(100) % 4 + 1;
    }

    // as of right now, randomly chosen box added to level
    public void addNewBox(){
        // adds new boxes based on timer to screen
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if (attackTimer < attackCooldown)
            return;

        // generate random number between 1 & 4 to new box of different types
        // first box generated outside of this method so it can be displayed in next box display
        int newBoxNum = nextBox;
        nextBox = rand.nextInt(100) % 4 + 1;

        // wanted outside if statement to only spawn boxes when player in well
        if (handler.getWorld().getEntityManager().getPlayer().getX() >= 120 &&
                handler.getWorld().getEntityManager().getPlayer().getX() < 560) {
            // adds cardboard box above player
            if (newBoxNum == 1) {
                CardboardBox cbox = new CardboardBox(handler, handler.getWorld().getEntityManager().getPlayer().getX(), -40);
                handler.getWorld().getEntityManager().addEntity(cbox);
            }
            // adds wood box above player
            if (newBoxNum == 2) {
                WoodBox wbox = new WoodBox(handler, handler.getWorld().getEntityManager().getPlayer().getX(), -40);
                handler.getWorld().getEntityManager().addEntity(wbox);
            }
            // adds metal box above player
            if (newBoxNum == 3) {
                MetalBox mbox = new MetalBox(handler, handler.getWorld().getEntityManager().getPlayer().getX(), -40);
                handler.getWorld().getEntityManager().addEntity(mbox);
            }
            // adds stone box above player
            if (newBoxNum == 4) {
                StoneBox sbox = new StoneBox(handler, handler.getWorld().getEntityManager().getPlayer().getX(), -40);
                handler.getWorld().getEntityManager().addEntity(sbox);
            }
        }
        // reset timer
        attackTimer = 0;
    }

    @Override
    public void tick() {
        // check for movement
        getInput();
        // add a box of timer permits
        addNewBox();

        // if player doesn't have a box below where it's trying to move,
        // it will fall
        if (!(getEntityCollided(0, 20) instanceof Box)){
            y += 40;
        }

        // if collides with a stop button from right or left side, trigger next level
        // by changing state
        if (getEntityCollided(40, 0) instanceof StopButton || getEntityCollided(-40, 0) instanceof StopButton){
//            handler.getGame().nextLevel();
            handler.getGame().setState(handler.getGame().nextLevelState);
        }
    }

    // draws life count to screen
    // draws player
    // draws next box coming up
    @Override
    public void render(Graphics g) {
        // lifecount
        int xpos = 30;
        for (int i = 0; i < lifeCount; i++){
            g.drawImage(Assets.life, xpos, 360, null);
            xpos += 20;
        }

        // drawing next box in bottom right corner of screen
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

        // draw player
        g.drawImage(Assets.player, x, y, null);
    }

    // gets input from keyboard
    private void getInput(){
            if (handler.getControl().left) {
                this.rotateLeft();
            }
            if (handler.getControl().right) {
                this.rotateRight();
            }

    }

    // if lives run out, isDead will be true when end state triggered
    // so we wills ee game over screen, not you win
    public boolean getDeadStatus(){
        return isDead;
    }

    public int getLifeCount(){
        return lifeCount;
    }

    public void setLifeCount(int lifeCount){
        this.lifeCount = lifeCount;
    }

    // when player dies, reduce lifeCount and trigger try again state
    // if life count 0, then trigger overstate for game over
    @Override
    public void die() {
//        handler.getWorld().getEntityManager().removeEntity(this);
        lifeCount--;
        health = 1;
        // to respawn
        x = handler.getWorld().getSpawnX1();
        y = handler.getWorld().getSpawnY1();

        if (lifeCount != 0) {
            // to remove game objects from screen
            handler.getWorld().getEntityManager().clearEntities();
            handler.getGame().setState(handler.getGame().tryAgainState);
        }

        else if (lifeCount == 0) {
            isDead = true;
            handler.getGame().setState(handler.getGame().overState);
        }
    }
}
