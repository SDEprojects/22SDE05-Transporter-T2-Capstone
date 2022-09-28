package com.tlglearning.controller;

import com.tlglearning.model.Player;
import com.tlglearning.view.Sound;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandlerB implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public static boolean spacePressed, enterPressed, hPressed, mPressed, twoPressed, threePressed, fourPressed, fivePressed;

    int musicChoice = 1;

    Sound music = new Sound();

    private GamePanelB gp;


    @Override
    public void keyTyped(KeyEvent e) {
    }


    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP) {
            upPressed = true;
        }
        if (code == KeyEvent.VK_DOWN) {
            downPressed = true;
        }
        if (code == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }
        if (code == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }
        if (code == KeyEvent.VK_SPACE) {
            if (!Player.neededItems.contains("Radio")) {
                if (!spacePressed) {
                    spacePressed = true;

                    if (!music.isPlaying){
                        if (musicChoice % 4 == 1) {
                            music.setMainFile(0);
                        } else if (musicChoice % 4 == 2) {
                            music.setMainFile(1);
                        }else if (musicChoice % 4 == 3) {
                            music.setMainFile(3);
                        }
                        else {
                            music.setMainFile(2);
                        }
                        music.playMain();
                        music.loopMain();
                        musicChoice++;
                    }

                } else {
                    spacePressed = false;
                    music.stopMain();
                }
            }
        }

        if (code == KeyEvent.VK_V) {
            final float volume = music.getVolume();
            if (volume < 0.90f) {
                music.setVolume(volume + 0.10f);
            }
            else {
                music.setVolume(1.0f);
            }


        }

        if (code == KeyEvent.VK_C) {
            final float volume = music.getVolume();

            if (volume > 0.10f) {
                music.setVolume(volume - 0.10f);
            }
            else {
                music.setVolume(0.0f);
            }


        }
        if (code == KeyEvent.VK_ENTER) {
            enterPressed = true;
        }
        if (code == KeyEvent.VK_H) {
            hPressed = !hPressed;
            mPressed = false;
        }
        if (code == KeyEvent.VK_M) {
            mPressed = !mPressed;
            hPressed = false;
        }
        if (code == KeyEvent.VK_2) {
            twoPressed = !twoPressed;
            threePressed = false;
            fourPressed = false;
            fivePressed = false;
        }
        if (code == KeyEvent.VK_3) {
            threePressed = !threePressed;
            twoPressed = false;
            fourPressed = false;
            fivePressed = false;
        }
        if (code == KeyEvent.VK_4) {
            fourPressed = !fourPressed;
            twoPressed = false;
            threePressed = false;
            fivePressed = false;
        }
        if (code == KeyEvent.VK_5) {
            fivePressed = !fivePressed;
            twoPressed = false;
            threePressed = false;
            fourPressed = false;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
    }
}