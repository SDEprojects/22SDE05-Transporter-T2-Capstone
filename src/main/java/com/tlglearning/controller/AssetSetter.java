package com.tlglearning.controller;

import com.tlglearning.model.State;
import com.tlglearning.model.objects.*;

public class AssetSetter {

    GamePanelB gp;

    public AssetSetter(GamePanelB gp) {
        this.gp = gp;
    }

    public void setObject(){
        gp.obj[0] = new OBJ_Key();
        gp.obj[0].worldX = 29 * gp.tileSize;
        gp.obj[0].worldY = 198 * gp.tileSize;

        gp.obj[1] = new OBJ_Key();
        gp.obj[1].worldX = 20 * gp.tileSize;
        gp.obj[1].worldY = 20 * gp.tileSize;

//        gp.obj[2] = new OBJ_Door1();
//        gp.obj[2].worldX = 4 * gp.tileSize;
//        gp.obj[2].worldY = 181 * gp.tileSize;

        gp.obj[3] = new OBJ_Door();
        gp.obj[3].worldX = 34 * gp.tileSize;
        gp.obj[3].worldY = 181 * gp.tileSize;

        gp.obj[4] = new OBJ_Chest();
        gp.obj[4].worldX = 35 * gp.tileSize;
        gp.obj[4].worldY = 35 * gp.tileSize;

        gp.obj[5] = new OBJ_Thermos();
        gp.obj[5].worldX = 40 * gp.tileSize;
        gp.obj[5].worldY = 187 * gp.tileSize;


        gp.obj[7] = new OBJ_Desk();
        gp.obj[7].worldX = 16 * gp.tileSize;
        gp.obj[7].worldY = 176 * gp.tileSize;

        gp.obj[8] = new OBJ_Vending();
        gp.obj[8].worldX = 26 * gp.tileSize;
        gp.obj[8].worldY = 182 * gp.tileSize;

        gp.obj[9] = new OBJ_Coffee();
        gp.obj[9].worldX = 36 * gp.tileSize;
        gp.obj[9].worldY = 182 * gp.tileSize;

        gp.obj[10] = new OBJ_NPC1();
        gp.obj[10].worldX = 28 * gp.tileSize;
        gp.obj[10].worldY = 195 * gp.tileSize;
        gp.obj[10].collision = true;

        gp.obj[11] = new OBJ_TruckKey();
        gp.obj[11].worldX = 38 * gp.tileSize;
        gp.obj[11].worldY = 178 * gp.tileSize;

        gp.obj[12] = new OBJ_Truck();
        gp.obj[12].worldX = 4 * gp.tileSize;
        gp.obj[12].worldY = 178 * gp.tileSize;



        gp.obj[13] = new OBJ_Package(State.IL);
        gp.obj[13].worldX = 5 * gp.tileSize;
        gp.obj[13].worldY = 160 * gp.tileSize;

        gp.obj[14] = new OBJ_Package(State.TN);
        gp.obj[14].worldX = 5 * gp.tileSize;
        gp.obj[14].worldY = 162 * gp.tileSize;

        gp.obj[15] = new OBJ_Package(State.KY);
        gp.obj[15].worldX = 5 * gp.tileSize;
        gp.obj[15].worldY = 164 * gp.tileSize;

        gp.obj[16] = new OBJ_Package(State.OH);
        gp.obj[16].worldX = 5 * gp.tileSize;
        gp.obj[16].worldY = 166 * gp.tileSize;

        gp.obj[17] = new OBJ_Package(State.SC);
        gp.obj[17].worldX = 5 * gp.tileSize;
        gp.obj[17].worldY = 168 * gp.tileSize;

    }

}
