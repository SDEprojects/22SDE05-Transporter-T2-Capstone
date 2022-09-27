package com.tlglearning.model.objects;

import com.tlglearning.model.SuperObject;

import javax.imageio.ImageIO;

public class OBJ_Desk extends SuperObject {
    public OBJ_Desk() {
        name = "Desk";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/bossdesk.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
