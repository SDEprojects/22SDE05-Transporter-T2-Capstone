package com.tlglearning.model;

import javax.imageio.ImageIO;

public class WinScreen extends SuperObject {
    public WinScreen() {
        name = "Win";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/intro_bg.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

