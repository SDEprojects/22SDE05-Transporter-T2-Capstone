package com.tlglearning.model.objects;

import com.tlglearning.model.SuperObject;

import javax.imageio.ImageIO;

public class OBJ_Vending extends SuperObject {

    public OBJ_Vending() {
        name = "Vending";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/vending.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


