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

    public final int screenX;
    public final int screenY;

    public Player(GamePanelB gp, KeyHandlerB keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        /* Used to set the player's collision radius, slightly smaller than a tile */
        solidArea = new Rectangle(8, 16, 32, 32);

        setDefaultPosition();
        getPlayerImage();
    }

    /* Set Players default position */
    public void setDefaultPosition() {
        worldX = gp.tileSize*23;
        worldY = gp.tileSize*21;
        speed = 14;
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

        if (keyH.upPressed) {
            direction = "up";
        }
        else if (keyH.downPressed) {
            direction = "down";
        }
        else if (keyH.leftPressed) {
            direction = "left";
        }
        else if (keyH.rightPressed) {
            direction = "right";
        }
        /* Check for collision */
        collisionOn = false;
        gp.cChecker.checkTile(this);

        /* If collision is off, player can move */
        if(!collisionOn){
            switch (direction) {
                case "up":
                    worldY -= speed;
                    break;
                case "down":
                    worldY += speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;
            }
        }
            spriteCounter++;
            if(spriteCounter > 12){
                if(spriteNum==1){
                    spriteNum = 2;
                }
                else if (spriteNum==2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
        else{
            spriteNum = 1;
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
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }

    public void moveUp() {
        worldY -= speed;
    }

    public void moveDown() {
        worldY += speed;
    }

    public void moveLeft() {
        worldX -= speed;
    }

    public void moveRight() {
        worldX += speed;
    }
}
