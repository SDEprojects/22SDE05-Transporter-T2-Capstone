package com.tlglearning.controller;

import com.tlglearning.model.objects.OBJ_Key;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {

    GamePanelB gp;
    Font arial_20;
    Font arial_80B;
    BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    public int messageCounter = 0;
    public boolean gameFinished = false;
    double playTime;
    boolean messageFlag = true;
    DecimalFormat df = new DecimalFormat("#0.00");


    public UI(GamePanelB gp) {
        this.gp = gp;
        arial_20 = new Font("Arial", Font.PLAIN, 20);
        arial_80B = new Font("Arial", Font.BOLD, 80);
        OBJ_Key key = new OBJ_Key();
        keyImage = key.image;
    }

    public void showMessage(String text) {
//        message = text;
//        messageOn = true;



        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                if (messageFlag){
                    message = text;
                    messageOn = true;
                    messageFlag = false;
                    try {
                        Thread.sleep(1300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    messageFlag = true;
                }
            }
        });
        t.start();
    }

    public void draw(Graphics2D g2) {


        if (gameFinished) {

            g2.setFont(arial_20);
            g2.setColor(Color.WHITE);

            String text;
            int textLength;
            int x;
            int y;

            text = "You have finished the game!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth / 2 - textLength/2;
            y = gp.screenHeight / 2 - (gp.tileSize*3);
            g2.drawString(text, x, y);


            text = "Your total time was " + df.format(playTime) + " seconds. Play again to beat your time!!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth / 2 - textLength/2;
            y = gp.screenHeight / 2 - (gp.tileSize);
            g2.drawString(text, x, y);



            g2.setFont(arial_80B);
            g2.setColor(Color.YELLOW);
            text = "Congratulations!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth / 2 - textLength/2;
            y = gp.screenHeight / 2 + (gp.tileSize*2);
            g2.drawString(text, x, y);


            gp.gameThread.stop();

        } else {
            /* static display, inventory, destination, potentially state */
//            g2.setColor(Color.WHITE);
//            g2.setFont(arial_20);
//            g2.drawImage(keyImage, gp.tileSize / 2, gp.tileSize / 2, gp.tileSize - 20, gp.tileSize - 20, null);
//            g2.drawString("= " + gp.player.hasKey, 50, 50);
//            g2.drawString("Destination: " + "South Carolina", 95, 50);
//            g2.setColor(Color.WHITE);
//            g2.fillRect(0, gp.tileSize*11, gp.screenWidth, gp.screenHeight / 4);
            g2.setColor(Color.GRAY);
            g2.fillRect(0, gp.tileSize*10, gp.screenWidth, gp.screenHeight / 3);
            g2.setFont(arial_20);
            g2.setColor(Color.WHITE);
            g2.drawImage(keyImage, 0, gp.tileSize*11, gp.tileSize - 20, gp.tileSize - 20, null);
            g2.drawString("= " + gp.player.hasKey, 35, gp.tileSize*11+20);
            g2.drawString("Destination: " + "South Carolina", 95, gp.tileSize*11+20);
            ;
            playTime +=(double)1/60;
//            g2.drawString("Time: " + df.format(playTime), gp.tileSize*13, 50);


            if (messageOn) {


                g2.setColor(Color.WHITE);
                g2.setFont(g2.getFont().deriveFont(15f));
                g2.drawString(message, gp.tileSize / 2, gp.tileSize * 11 - 20);

                messageCounter++;
                if (messageCounter > 180) {
                    messageCounter = 0;
                    messageOn = false;
                }

            }


        }


    }
    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
