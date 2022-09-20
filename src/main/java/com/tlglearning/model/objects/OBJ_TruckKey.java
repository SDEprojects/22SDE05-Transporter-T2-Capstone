package com.tlglearning.model.objects;

import com.tlglearning.model.SuperObject;

import javax.imageio.ImageIO;

public class OBJ_TruckKey extends SuperObject {
    public OBJ_TruckKey() {
        name = "TruckKey";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/truckkey.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
