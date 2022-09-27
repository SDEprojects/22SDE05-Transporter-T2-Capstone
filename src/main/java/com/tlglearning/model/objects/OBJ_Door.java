package com.tlglearning.model.objects;

import com.tlglearning.model.SuperObject;

import javax.imageio.ImageIO;

public class OBJ_Door extends SuperObject {
    public static SuperObject image1;

    public OBJ_Door() {
        name = "Door";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/doorclosed.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
    }


}
