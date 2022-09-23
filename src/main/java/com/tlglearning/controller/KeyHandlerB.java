package com.tlglearning.controller;

import com.tlglearning.model.Player;
import com.tlglearning.view.Sound;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandlerB implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public static boolean spacePressed, enterPressed, hPressed;

    int musicChoice = 1;

    Sound music = new Sound();

    private GamePanelB gp;


    @Override
    public void keyTyped(KeyEvent e) {
    }




    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_UP){
            upPressed = true;
        }
        if(code == KeyEvent.VK_DOWN){
            downPressed = true;
        }
        if(code == KeyEvent.VK_LEFT){
            leftPressed = true;
        }
        if(code == KeyEvent.VK_RIGHT){
            rightPressed = true;
        }
        if(code == KeyEvent.VK_SPACE) {
            if (!Player.neededItems.contains("Radio")) {
                if (!spacePressed) {
                    spacePressed = true;

                    if (musicChoice % 2 == 1) {
                        music.setFile(0);
                    } else {
                        music.setFile(1);
                    }
                    music.play();
                    music.loop();
                    musicChoice++;


                } else {
                    spacePressed = false;
                    music.stop();
                }
            }
        }
        if(code == KeyEvent.VK_ENTER){
            enterPressed = true;
        }
        if(code == KeyEvent.VK_H){
            if (!hPressed) {
                hPressed = true;
            }
            else {
                hPressed = false;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_UP){
            upPressed = false;
        }
        if(code == KeyEvent.VK_DOWN){
            downPressed = false;
        }
        if(code == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }
    }
}