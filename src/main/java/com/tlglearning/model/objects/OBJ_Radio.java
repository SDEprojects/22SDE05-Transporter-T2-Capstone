package com.tlglearning.model.objects;

import com.tlglearning.model.SuperObject;

import javax.imageio.ImageIO;

public class OBJ_Radio extends SuperObject {
    public OBJ_Radio() {
        name = "radio";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/radio.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
