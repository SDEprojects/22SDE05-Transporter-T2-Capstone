package com.tlglearning.model;

import javax.imageio.ImageIO;

public class LoseScreen extends SuperObject {
    public LoseScreen() {
        name = "Lose";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/lose_bg.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

