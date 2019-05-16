/* Lazarus
Created By: Stephanie Sechrist
Last Edited: May 15, 2019

Most of code reused from my tank game.

To make tank game, I followed along with a YouTube tutorial made by CodeNMore.
The series is called "New Beginner 2D Game Programming" and a lot of my program
structure comes from following along with him. In addition, my tank control was largely
taken from Souza's TRE he provided on iLearn.
 */

package dev;

import Display.Display;
import dev.graphics.Assets;
import dev.input.PlayerControl;
import dev.states.*;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{
    private Display display;
    private int width, height;
    private boolean isRunning = false;
    public String title;
    private int levelNum = 1;

    private Thread thread;
    private BufferStrategy bs;
    private Graphics g;

    // States public so can be accessed everywhere
    // probably not best way to do this, but it works for now
    public State gameState;
    public State introState;
    public State overState;
    public State tryAgainState;
    public State nextLevelState;

    // Input
    private PlayerControl control;

    // Handler
    private Handler handler;

    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
        control = new PlayerControl();
    }

    private void init(){
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(control);

        // Load all images
        Assets.init();


        handler = new Handler(this);

        gameState = new GameState(handler);
        introState = new IntroState(handler);
        overState = new OverState(handler);
        tryAgainState = new TryAgainState(handler);
        nextLevelState = new NextLevelState(handler);

        // starts game on intro screen
        State.setState(introState);
//        State.setState(overState);
    }

    // update controls and update current state
    private void tick(){
        control.tick();

        if (State.getState() != null)
            State.getState().tick();
    }

    private void render(){

        bs = display.getCanvas().getBufferStrategy();
        if (bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        //        g = display.getPanel().getGraphics();

        g = bs.getDrawGraphics();
        // clear screen
        g.clearRect(0,0, width, height);

        //Draw
        // render state
        if (State.getState() != null)
            State.getState().render(g);

        //End draw
        bs.show();
        g.dispose();
    }

    // nextLevel incrememnts levelNum and
    // changes to nextLevel state to get to next level
    public void nextLevel(){
        levelNum++;

        if (State.getState() instanceof GameState){
            ((GameState) State.getState()).nextLevel();
        }
    }

    // run game!
    // math from CodeNMore; no way i could have figured out
    // the timer math alone!
    public void run(){
        init();

        // times per second I want tick & render methods to run
        int fps = 60;
        // timePerTick is the max time we're allowed to run tick &
        // render methods to achieve fps (in nanoseconds)
        double timePerTick = 1000000000 / fps;
        // amount of time until we have to call tick & render
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (isRunning) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if (timer >= 1000000000){
                //                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        // just in case thread hasn't been stopped
        stop();
    }

    public PlayerControl getControl() {
        return control;
    }

    public int getLevelNum() {
        return levelNum;
    }

    public void setLevelNum(int levelNum) {
        this.levelNum = levelNum;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setState(State state){
        State.setState(state);
    }

    public synchronized void start(){
        if (isRunning)
            return;
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if (!isRunning)
            return;
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
