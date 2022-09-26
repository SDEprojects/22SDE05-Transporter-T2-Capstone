package com.tlglearning.controller;

import com.tlglearning.model.State;
import com.tlglearning.model.objects.*;

public class AssetSetter {

    GamePanelB gp;

    public AssetSetter(GamePanelB gp) {
        this.gp = gp;
    }

    public void setObject(){

//        gp.obj[1] = new OBJ_Door1();
//        gp.obj[1].worldX = 4 * gp.tileSize;
//        gp.obj[1].worldY = 181 * gp.tileSize;

        gp.obj[3] = new OBJ_Door();
        gp.obj[3].worldX = 34 * gp.tileSize;
        gp.obj[3].worldY = 181 * gp.tileSize;

        gp.obj[5] = new OBJ_Thermos();
        gp.obj[5].worldX = 42 * gp.tileSize;
        gp.obj[5].worldY = 187 * gp.tileSize;


        gp.obj[7] = new OBJ_Desk();
        gp.obj[7].worldX = 16 * gp.tileSize;
        gp.obj[7].worldY = 176 * gp.tileSize;

        gp.obj[8] = new OBJ_Vending();
        gp.obj[8].worldX = 15 * gp.tileSize;
        gp.obj[8].worldY = 182 * gp.tileSize;

        gp.obj[9] = new OBJ_Coffee();
        gp.obj[9].worldX = 36 * gp.tileSize;
        gp.obj[9].worldY = 182 * gp.tileSize;

        gp.obj[10] = new OBJ_NPC1();
        gp.obj[10].worldX = 28 * gp.tileSize;
        gp.obj[10].worldY = 195 * gp.tileSize;
        gp.obj[10].collision = true;

        gp.obj[11] = new OBJ_TruckKey();
        gp.obj[11].worldX = 3 * gp.tileSize;
        gp.obj[11].worldY = 197 * gp.tileSize;

        gp.obj[12] = new OBJ_Truck();
        gp.obj[12].worldX = 4 * gp.tileSize;
        gp.obj[12].worldY = 178 * gp.tileSize;

        gp.obj[13] = new OBJ_Package(State.IL);
        gp.obj[13].worldX = 8 * gp.tileSize;
        gp.obj[13].worldY = 140 * gp.tileSize;

        gp.obj[14] = new OBJ_Package(State.TN);
        gp.obj[14].worldX = 5 * gp.tileSize;
        gp.obj[14].worldY = 162 * gp.tileSize;

        gp.obj[15] = new OBJ_Package(State.KY);
        gp.obj[15].worldX = 7 * gp.tileSize;
        gp.obj[15].worldY = 154 * gp.tileSize;

        gp.obj[16] = new OBJ_Package(State.OH);
        gp.obj[16].worldX = 7 * gp.tileSize;
        gp.obj[16].worldY = 146 * gp.tileSize;

        gp.obj[17] = new OBJ_Package(State.SC);
        gp.obj[17].worldX = 2 * gp.tileSize;
        gp.obj[17].worldY = 168 * gp.tileSize;

        gp.obj[18] = new OBJ_Package(State.MS);
        gp.obj[18].worldX = 10 * gp.tileSize;
        gp.obj[18].worldY = 170 * gp.tileSize;

        gp.obj[19] = new OBJ_Package(State.AL);
        gp.obj[19].worldX = 14 * gp.tileSize;
        gp.obj[19].worldY = 169 * gp.tileSize;

        gp.obj[30] = new OBJ_GPS();
        gp.obj[30].worldX = 40 * gp.tileSize;
        gp.obj[30].worldY = 178 * gp.tileSize;

        gp.obj[31] = new OBJ_Radio();
        gp.obj[31].worldX = 26 * gp.tileSize;
        gp.obj[31].worldY = 176 * gp.tileSize;

        gp.obj[32] = new OBJ_GasPump();
        gp.obj[32].worldX = 26 * gp.tileSize;
        gp.obj[32].worldY = 165 * gp.tileSize;


    }

}


