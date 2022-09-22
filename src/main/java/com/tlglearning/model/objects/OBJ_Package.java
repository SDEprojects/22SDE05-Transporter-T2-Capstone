package com.tlglearning.model.objects;

import com.tlglearning.model.State;
import com.tlglearning.model.SuperObject;

import javax.imageio.ImageIO;

public class OBJ_Package extends SuperObject {

    public boolean pickedUp = false;

    private State state;
    public OBJ_Package(State state) {




        name = "Package";
        this.state = state;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/package.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public State getState(){
        return state;
    }

}
