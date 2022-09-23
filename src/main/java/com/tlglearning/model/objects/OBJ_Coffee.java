package com.tlglearning.model.objects;

import com.tlglearning.model.SuperObject;

import javax.imageio.ImageIO;

public class OBJ_Coffee extends SuperObject {

    public OBJ_Coffee() {
        name = "Coffee";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/coffee.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
    }

}


