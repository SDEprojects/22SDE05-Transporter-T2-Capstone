package com.tlglearning.controller;

import com.tlglearning.model.Player;
import com.tlglearning.model.SuperObject;
import com.tlglearning.model.TileManager;
import com.tlglearning.view.Sound;

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

    public final int maxWorldCol = 250;
    public final int maxWorldRow = 250;

    int FPS = 60;
    boolean soundEffectFlag = true;

    public TileManager tileM = new TileManager(this);
    KeyHandlerB keyH = new KeyHandlerB();
    Sound sound = new Sound();
    Sound music = new Sound();

    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    Thread gameThread;

    public Player player = new Player(this, keyH);
    public SuperObject obj[] = new SuperObject[25];


    public GamePanelB() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setUpGame() {

        aSetter.setObject();
       // playMusic(0);
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


            } catch (InterruptedException e) {
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

        /* Draw the background */
        tileM.draw(g2);

        /* Draw the objects */
        for (SuperObject superObject : obj) {
            if (superObject != null) {
                superObject.draw(g2, this);
            }
        }

        /* Draw the player */
        player.draw(g2);

        /* Draw the UI,have multiple for play inventory in office vs driving etc.. */
//        if (player.worldY<2000) {
            ui.draw(g2);
//        }
//        ui.draw(g2);


        g2.dispose();
    }

    public void playMusic(int i){
        music.setFile(i);
        music.play();
        music.loop();
    }
    public void stopMusic(){
        music.stop();
    }

    public void playSE(int i){
        Thread sound1 = new Thread(new Runnable() {

            @Override
            public void run() {

                if (soundEffectFlag) {

                    soundEffectFlag = false;
                    sound.setFile(i);
                    sound.play();
                    sleep(1300);
                    soundEffectFlag = true;
                }

            }
        });
        sound1.start();

//        sound.setFile(i);
//        sound.play();
    }

    public void sleep(int i){
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
