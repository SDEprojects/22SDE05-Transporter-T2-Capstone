package com.tlglearning.model.objects;

import com.tlglearning.model.SuperObject;

import javax.imageio.ImageIO;

public class OBJ_NPC1 extends SuperObject {
    public OBJ_NPC1() {
        name = "NPC1";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/girlnpc.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
