/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerControl implements KeyListener {
    private boolean[] keys;
    //    private static int[] keys;
    public boolean left, right, play, exit;
    //    public int up1, down1, left1, right1;

    public PlayerControl() {
        keys = new boolean[256];
    }

    public void tick() {
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
        play = keys[KeyEvent.VK_P];
        exit = keys[KeyEvent.VK_ESCAPE];
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
}
