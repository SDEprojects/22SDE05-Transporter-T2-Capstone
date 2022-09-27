package com.tlglearning.model.objects;

import com.tlglearning.model.SuperObject;

import javax.imageio.ImageIO;

public class OBJ_Key extends SuperObject {
    public OBJ_Key() {
        name = "Key";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/key1.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
