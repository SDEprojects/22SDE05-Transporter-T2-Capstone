package com.tlglearning.model.objects;

import com.tlglearning.model.Player;
import com.tlglearning.model.SuperObject;

import javax.imageio.ImageIO;

public class OBJ_Gas extends SuperObject {
    String gasImage;
    private float g = Player.gasCount;
    public OBJ_Gas() {
        name = "Gas";
        try {
            image = ImageIO.read(getClass().getResourceAsStream(getGasImage()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getGasImage(){


        if (g>=97 && g<=100){
            gasImage = "/objects/allgas/gas9.png";
        }
        else if(g>=86 && g<97){
            gasImage = "/objects/allgas/gas8.png";
        }
        else if(g>=73 && g<86){
            gasImage = "/objects/allgas/gas7.png";
        }
        else if(g>=64 && g<73){
            gasImage = "/objects/allgas/gas6.png";
        }
        else if(g>=56 && g<64){
            gasImage = "/objects/allgas/gas5.png";
        }
        else if(g>=44 && g<56){
            gasImage = "/objects/allgas/gas4.png";
        }
        else if(g>=28 && g<44){
            gasImage = "/objects/allgas/gas3.png";
        }
        else if(g>=14 && g<28){
            gasImage = "/objects/allgas/gas2.png";
        }
        else if(g>=1 && g<14){
            gasImage = "/objects/allgas/gas1.png";
        }
        else {
                gasImage = "/objects/allgas/gas0.png";
        }


        return gasImage;
    }

}
