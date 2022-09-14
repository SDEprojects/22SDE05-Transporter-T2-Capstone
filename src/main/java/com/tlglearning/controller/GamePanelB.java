package com.tlglearning.controller;

import com.tlglearning.model.Player;
import com.tlglearning.model.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanelB extends JPanel implements Runnable {

    final int originalTileSize = 16;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;
    public final int maxScreenColumn = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenColumn;
    public final int screenHeight = tileSize * maxScreenRow;

    int FPS = 60;

    TileManager tm = new TileManager(this);
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


    public void update() {
        player.update();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        tm.draw(g2);
        player.draw(g2);


        g2.dispose();
    }
}
