package com.tlglearning.model.objects;

import com.tlglearning.model.SuperObject;

import javax.imageio.ImageIO;

public class OBJ_Thermos extends SuperObject {

        public OBJ_Thermos() {
            name = "Thermos";

            try {
                image = ImageIO.read(getClass().getResourceAsStream("/objects/thermos.png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


