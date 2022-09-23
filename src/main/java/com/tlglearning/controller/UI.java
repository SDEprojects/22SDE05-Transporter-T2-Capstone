package com.tlglearning.controller;

import com.tlglearning.model.HelpMenu;
import com.tlglearning.model.Intro;
import com.tlglearning.model.Player;
import com.tlglearning.model.objects.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {

    GamePanelB gp;
    Font arial_20;
    Font introFont;
    Font arial_80B;
    BufferedImage keyImage;
    BufferedImage helpImage;

    BufferedImage introImage;

    BufferedImage coffeeImage;
    BufferedImage vendingImage;

    BufferedImage thermosImage;
    BufferedImage gpsImage;
    BufferedImage radioImage;
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
        introFont = new Font("DialogInput", Font.ITALIC, 60);
        arial_80B = new Font("Arial", Font.BOLD, 80);
        OBJ_Key key = new OBJ_Key();
        keyImage = key.image;
        OBJ_Coffee coffee = new OBJ_Coffee();
        coffeeImage = coffee.image;
        OBJ_Vending vending = new OBJ_Vending();
        vendingImage = vending.image;
        OBJ_Thermos thermos = new OBJ_Thermos();
        thermosImage = thermos.image;
        OBJ_GPS gps = new OBJ_GPS();
        gpsImage = gps.image;
        Intro intro = new Intro();
        introImage = intro.image;
        HelpMenu help = new HelpMenu();
        helpImage = help.image;

        OBJ_Radio radio = new OBJ_Radio();
        radioImage = radio.image;

    }

    public void showMessage(String text) {
//        message = text;
//        messageOn = true;


        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                if (messageFlag) {
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
            textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight / 2 - (gp.tileSize * 3);
            g2.drawString(text, x, y);


            text = "Your total time was " + df.format(playTime) + " seconds. Play again to beat your time!!";
            textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight / 2 - (gp.tileSize);
            g2.drawString(text, x, y);


            g2.setFont(arial_80B);
            g2.setColor(Color.YELLOW);
            text = "Congratulations!";
            textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight / 2 + (gp.tileSize * 2);
            g2.drawString(text, x, y);


            gp.gameThread.stop();

        } else {

            if (!KeyHandlerB.enterPressed) {

                String text;
                int textLength;
                int x;
                int y;
                int textLength1;
                int x1;
                int y1;
                int textLength2;
                int x2;
                int y2;
                int textLength3;
                int x3;
                int y3;

                text = "Welcome to Transporter!";
                String text1 = "Press h at any point in the game to see the help menu.";
                String text2 = "Press Enter when you are ready to get started!";
                String text3 = "TRANSPORTER!";
                textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
                textLength1 = (int) g2.getFontMetrics().getStringBounds(text1, g2).getWidth();
                textLength2 = (int) g2.getFontMetrics().getStringBounds(text2, g2).getWidth();
                textLength3 = (int) g2.getFontMetrics().getStringBounds(text3, g2).getWidth();
                x = gp.screenWidth / 2 - textLength / 2;
                y = gp.screenHeight / 2 - (gp.tileSize * 3);

                x1 = gp.screenWidth / 2 - textLength1 / 2;
                y1 = gp.screenHeight / 2 - (gp.tileSize * 3);

                x2 = gp.screenWidth / 2 - textLength2 / 2;
                y2 = gp.screenHeight / 2 - (gp.tileSize * 3);

                x3 = gp.screenWidth / 2 - textLength3 / 2;
                y3 = gp.screenHeight / 2 - (gp.tileSize * 3);

                g2.drawImage(introImage, 0, gp.tileSize - 50, gp.screenWidth, gp.screenHeight + 30, null);


                g2.setColor(Color.BLACK);
                g2.drawString(text, x, y+10);
                g2.drawString(text1, x1, y1+90);
                g2.drawString(text2, x2, y2+160);
                g2.setFont(introFont);
                g2.setColor(Color.RED);
                g2.drawString(text3, x3-160, y3-40);


            }
            if (KeyHandlerB.hPressed && KeyHandlerB.enterPressed) {

                String text;
                int textLength;
                int x;


                text = "You open an ancient scroll given to you by a mighty wizard...";
                String text1 = "- Get the needed items to get in the truck.";
                String text2 = "- Get in the truck and pickup the first package.";
                String text3 = "- Deliver 3 packages to win the game!";
                String text4 = "Your time is being recorded, hurry!  "+df.format(playTime);
                String text5 = "- Once acquired, press the space bar to start your radio.";
                String text6 = "- Press h to close the help menu.";
                String text7 = "Objective:";
                String text8 = "Controls: ";
                String text9 = "- up, down, left, right arrow keys to move.";

                textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
                x = gp.screenWidth / 2 - textLength / 2;

                g2.drawImage(helpImage, x, -10, gp.screenWidth / 2 + 100, gp.screenHeight / 3 + 80, null);


                g2.setColor(Color.BLACK);

                g2.drawString(text1, x + 60, 70);
                g2.drawString(text2, x + 60, 95);
                g2.drawString(text3, x + 60, 120);


                g2.setColor(Color.BLUE);

                g2.drawString(text9, x + 60, 165);

                g2.drawString(text5, x + 60, 190);
                g2.drawString(text6, x + 60, 215);

                g2.setColor(Color.RED);
                g2.drawString(text, x + 52, 20);
                g2.drawString(text4, x + 120, 250);
                g2.drawString(text7, x + 60, 50);
                g2.drawString(text8, x + 60, 145);

            }
            if (KeyHandlerB.enterPressed) {
                if (Player.truckFlag){
                    g2.setColor(Color.GRAY);
                    g2.fillRect(0, gp.tileSize * 10, gp.screenWidth, gp.screenHeight / 3);
                    g2.setFont(arial_20);
                    g2.setColor(Color.WHITE);
//                g2.drawImage(keyImage, 0, gp.tileSize * 11, gp.tileSize - 20, gp.tileSize - 20, null);
//                g2.drawString("= " + gp.player.hasKey, 35, gp.tileSize * 11 + 20);
                    g2.drawImage(gpsImage, 10, gp.tileSize * 11, gp.tileSize - 20, gp.tileSize - 20, null);
//                    g2.drawString("= " + gp.getPlayerState(), 45, gp.tileSize * 11+20);
                    g2.drawString("= " + gp.getPlayerState(), 45, gp.tileSize * 11+20);

                    g2.drawString("Destination: ", 185, gp.tileSize * 11+20);
                    g2.drawString(""+Player.packageCounter , 290, gp.tileSize * 11+20);

                    g2.drawString("Deliveries: ", 385, gp.tileSize * 11+20);
                    g2.drawString("= " + Player.packageCounter, 490, gp.tileSize * 11+20);
                }
                else if (!Player.truckFlag){
                    g2.setColor(Color.GRAY);
                    g2.fillRect(0, gp.tileSize * 10, gp.screenWidth, gp.screenHeight / 3);
                    g2.setFont(arial_20);
                    g2.setColor(Color.WHITE);
//                g2.drawImage(keyImage, 0, gp.tileSize * 11, gp.tileSize - 20, gp.tileSize - 20, null);
//                g2.drawString("= " + gp.player.hasKey, 35, gp.tileSize * 11 + 20);
                    g2.drawImage(gpsImage, 10, gp.tileSize * 11, gp.tileSize - 20, gp.tileSize - 20, null);
                    g2.drawString("= " + gp.getPlayerState(), 45, gp.tileSize * 11+20);

                    g2.drawImage(coffeeImage, 110, gp.tileSize * 11, gp.tileSize - 20, gp.tileSize - 20, null);
                    g2.drawString("= " + gp.getItemCount("Coffee"), 145, gp.tileSize * 11+20);

                    g2.drawImage(radioImage, 210, gp.tileSize * 11, gp.tileSize - 20, gp.tileSize - 20, null);
                    g2.drawString("= " + gp.getItemCount("Radio"), 245, gp.tileSize * 11+20);

                    g2.drawImage(thermosImage, 310, gp.tileSize * 11, gp.tileSize - 20, gp.tileSize - 20, null);
                    g2.drawString("= " + gp.getItemCount("Radio"), 345, gp.tileSize * 11+20);

                    g2.drawImage(vendingImage, 410, gp.tileSize * 11, gp.tileSize - 20, gp.tileSize - 20, null);
                    g2.drawString("= " + gp.getItemCount("Radio"), 445, gp.tileSize * 11+20);

                    g2.drawImage(radioImage, 510, gp.tileSize * 11, gp.tileSize - 20, gp.tileSize - 20, null);
                    g2.drawString("= " + gp.getItemCount("Radio"), 545, gp.tileSize * 11+20);
                }

                /* static display, inventory, destination, potentially state */
//            g2.setColor(Color.WHITE);
//            g2.setFont(arial_20);
//            g2.drawImage(keyImage, gp.tileSize / 2, gp.tileSize / 2, gp.tileSize - 20, gp.tileSize - 20, null);
//            g2.drawString("= " + gp.player.hasKey, 50, 50);
//            g2.drawString("Destination: " + "South Carolina", 95, 50);
//            g2.setColor(Color.WHITE);
//            g2.fillRect(0, gp.tileSize*11, gp.screenWidth, gp.screenHeight / 4);
//                g2.setColor(Color.GRAY);
//                g2.fillRect(0, gp.tileSize * 10, gp.screenWidth, gp.screenHeight / 3);
//                g2.setFont(arial_20);
//                g2.setColor(Color.WHITE);
////                g2.drawImage(keyImage, 0, gp.tileSize * 11, gp.tileSize - 20, gp.tileSize - 20, null);
////                g2.drawString("= " + gp.player.hasKey, 35, gp.tileSize * 11 + 20);
//                g2.drawImage(gpsImage, 10, gp.tileSize * 11, gp.tileSize - 20, gp.tileSize - 20, null);
//                g2.drawString("= " + gp.getPlayerState(), 45, gp.tileSize * 11+20);
//                g2.drawString("= " + gp.getPlayerState(), 95, gp.tileSize * 10 + 20);


                playTime += (double) 1 / 60;
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
    }



    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}