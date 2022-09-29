package com.tlglearning.model.objects;

import com.tlglearning.model.SuperObject;

import javax.imageio.ImageIO;

/* This will be the red door which is needed for the truck  */
public class OBJ_Door1 extends SuperObject {

    public OBJ_Door1() {
        name = "Door1";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/doorclosed1.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
    }


}
