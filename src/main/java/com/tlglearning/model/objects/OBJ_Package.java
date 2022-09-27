package com.tlglearning.model.objects;

import com.tlglearning.model.State;
import com.tlglearning.model.SuperObject;

import javax.imageio.ImageIO;

public class OBJ_Package extends SuperObject {

    private boolean pickedUp = false;


    private State state;
    private State destination;
    public OBJ_Package(State state) {

        name = "Package";
        this.state = state;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/package.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean getPickedUp(){

        if (pickedUp == true){
            return false;
        }

        pickedUp = true;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/packageempty.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public void setDestination(State state){
        this.destination = state;
    }

    public State getDestination(){
        return destination;
    }


    public State getState(){
        return state;
    }

}