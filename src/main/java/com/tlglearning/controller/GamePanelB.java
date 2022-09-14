package com.tlglearning.controller;

import com.tlglearning.model.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanelB extends JPanel implements Runnable {

    final int originalTileSize = 16;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;
    final int maxScreenColumn = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenColumn;
    final int screenHeight = tileSize * maxScreenRow;

    int FPS = 60;

    KeyHandlerB keyH = new KeyHandlerB();
    Thread gameThread;

    Player player = new Player(this, keyH);


    public GamePanelB() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    /* Start Game */
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while (true) {
            update();
            repaint();



            try {
                Thread.sleep(1000 / FPS);


            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



//        double drawInterval = 1000000000 / FPS;
//        double nextDrawTime = System.nanoTime() + drawInterval;
//
//        while (true) {
//            update();
//            repaint();
//
//            try {
//                double remainingTime = nextDrawTime - System.nanoTime();
//                remainingTime = remainingTime / 1000000;
//
//                if (remainingTime < 0) {
//                    remainingTime = 0;
//                }
//
//                Thread.sleep((long) remainingTime);
//
//                nextDrawTime += drawInterval;
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        while (gameThread != null) {
//
//            long currentTime = System.nanoTime();
//
//            /* Update information such as character position, enemy position */
//            update();
//            /* Draw the game with the updated information*/
//            repaint();
//
//        }

    public void update() {
        player.update();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        player.draw(g2);


        g2.dispose();
    }
}
