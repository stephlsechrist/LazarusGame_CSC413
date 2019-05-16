/*
 * PlayerControl uses boolean array that uses keyCode of input. if the index
 * of array is true, action will occur
 *
 * not many controls in this game, so there's probably a more efficient way
 * of doing this rather than creating an array of size 256...
 *
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerControl implements KeyListener {
    private boolean[] keys;
    public boolean left, right, play, exit;

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
