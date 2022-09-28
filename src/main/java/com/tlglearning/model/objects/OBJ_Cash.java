package com.tlglearning.model.objects;

import com.tlglearning.model.SuperObject;

import javax.imageio.ImageIO;

public class OBJ_Cash extends SuperObject {
    public OBJ_Cash() {
        name = "Cash";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/coin.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
