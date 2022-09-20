package com.tlglearning.model.objects;

import com.tlglearning.model.SuperObject;

import javax.imageio.ImageIO;

public class OBJ_Truck extends SuperObject {
    public OBJ_Truck() {
        name = "Truck";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/truck_up.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
