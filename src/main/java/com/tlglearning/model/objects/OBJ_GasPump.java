package com.tlglearning.model.objects;

import com.tlglearning.model.SuperObject;

import javax.imageio.ImageIO;

public class OBJ_GasPump extends SuperObject {
    public OBJ_GasPump() {
        name = "GasPump";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/gas_pump.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
