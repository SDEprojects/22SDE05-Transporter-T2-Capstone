package com.tlglearning.model.objects;

import com.tlglearning.model.SuperObject;

import javax.imageio.ImageIO;

public class OBJ_Package extends SuperObject {
    public OBJ_Package() {
        name = "Package";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/worldobjects/package.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
