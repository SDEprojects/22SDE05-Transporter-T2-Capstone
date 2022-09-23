package com.tlglearning.model.objects;

import com.tlglearning.model.SuperObject;

import javax.imageio.ImageIO;

public class OBJ_Folder extends SuperObject {
    public OBJ_Folder() {
        name = "Folder";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/folder.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
