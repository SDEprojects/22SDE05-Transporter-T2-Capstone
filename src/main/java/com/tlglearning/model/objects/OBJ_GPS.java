package com.tlglearning.model.objects;

import com.tlglearning.model.SuperObject;

import javax.imageio.ImageIO;

public class OBJ_GPS extends SuperObject {

    public OBJ_GPS() {
        name = "GPS";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/gps.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
