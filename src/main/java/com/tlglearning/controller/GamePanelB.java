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
    public final int maxWorldRow = 200;

    int FPS = 60;
    boolean soundEffectFlag = true;

    public TileManager tileM = new TileManager(this);
    KeyHandlerB keyH = new KeyHandlerB();
    Sound sound = new Sound();
    Sound music = new Sound();

    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public Player player = new Player(this, keyH);
    public UI ui = new UI(this, player);


    Thread gameThread;


    public SuperObject obj[] = new SuperObject[35];


    public GamePanelB() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setUpGame() {

        aSetter.setObject();

//        playMusic(0);

//        playMusic(0);

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
        try {

            ui.draw(g2);
        }
        catch (Exception ignore) {
        }



        g2.dispose();
    }

    public void playMusic(int i) {
        music.setFile(i);
        music.play();
        music.loop();
    }

    public void stopMusic() {
        music.stop();
    }

    public void playSE(int i) {
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

    public void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public String getPlayerState() {
        int x = player.worldX;
        int y = player.worldY;
        String state = " ";

        if (Player.neededItems.contains("GPS")) {
            state = "0";
        } else {

            if (x > 0 && x < 5000 && y > 6700 && y < 9700) {
                state = "MS";
            } else if (x > 0 && x < 8001 && y > 4200 && y < 6700) {
                state = "TN";
            } else if (x > 0 && x < 8500 && y > 2501 && y < 4200) {
                state = "KY";
            } else if (x > 0 && x < 2000 && y > 0 && y < 2200) {
                state = "IL";
            } else if (x > 4000 && x < 7001 && y > 0 && y < 2200) {
                state = "OH";
            } else if (x > 2001 && x < 3900 && y > 0 && y < 2200) {
                state = "IN";
            } else if (x > 5001 && x < 8550 && y > 6701 && y < 9700) {
                state = "AL";
            } else if (x > 8551 && x < 12000 && y > 7701 && y < 9700) {
                state = "GA";
            } else if (x > 9900 && x < 12000 && y > 6700 && y < 7700) {
                state = "SC";
            } else if (x > 8000 && x < 12000 && y > 4200 && y < 6699) {
                state = "NC";
            } else if (x > 8500 && x < 12000 && y > 2001 && y < 4200) {
                state = "VA";
            } else if (x > 9800 && x < 12000 && y > 0 && y < 2001) {
                state = "MD";
            } else if (x > 7000 && x < 9801 && y > 0 && y < 2501) {
                state = "WV";
            } else {
                state = "No Signal";
            }
        }
        return state;
    }

    public int getItemCount(String s){

        if (Player.neededItems.contains(s)){
            return 0;
        }
        return 1;
    }
}
