package com.tlglearning.model;

import com.tlglearning.controller.GamePanelB;
import com.tlglearning.controller.KeyHandlerB;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends EntityB {

    GamePanelB gp;
    KeyHandlerB keyH;

    public Player(GamePanelB gp, KeyHandlerB keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultPosition();
        getPlayerImage();
    }

    /* Set Players default position */
    public void setDefaultPosition() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage(){
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player1/player_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player1/player_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player1/player_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player1/player_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player1/player_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player1/player_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player1/player_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player1/player_right_2.png"));
//            down1 = ImageIO.read(new FileInputStream("src/main/resources/player1/player_down1.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void update() {

        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed){
            spriteCounter++;
            if(spriteCounter > 10){
                spriteCounter = 0;
                if(spriteNum == 1){
                    spriteNum = 2;
                }
                else{
                    spriteNum = 1;
                }
            }
        }
        else{
            spriteNum = 1;
        }

        if (keyH.upPressed) {
            direction = "up";
            y -= speed;
        }
        if (keyH.downPressed) {
            direction = "down";
            y += speed;
        }
        if (keyH.leftPressed) {
            direction = "left";
            x -= speed;
        }
        if (keyH.rightPressed) {
            direction = "right";
            x += speed;
        }

    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch(direction){
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                else {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                else {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                else {
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }

    public void moveUp() {
        y -= speed;
    }

    public void moveDown() {
        y += speed;
    }

    public void moveLeft() {
        x -= speed;
    }

    public void moveRight() {
        x += speed;
    }
}
