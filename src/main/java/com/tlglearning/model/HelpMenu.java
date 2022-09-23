package com.tlglearning.model;

import javax.imageio.ImageIO;

public class HelpMenu extends SuperObject {
    public HelpMenu() {
        name = "Help";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/help_bg.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

