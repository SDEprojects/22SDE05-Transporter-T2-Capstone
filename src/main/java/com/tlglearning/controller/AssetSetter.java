package com.tlglearning.controller;

import com.tlglearning.model.State;
import com.tlglearning.model.objects.*;

import java.util.Random;

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

        gp.obj[30] = new OBJ_GPS();
        gp.obj[30].worldX = 40 * gp.tileSize;
        gp.obj[30].worldY = 178 * gp.tileSize;

        gp.obj[31] = new OBJ_Radio();
        gp.obj[31].worldX = 26 * gp.tileSize;
        gp.obj[31].worldY = 176 * gp.tileSize;

        gp.obj[33] = new OBJ_GasPump();
        gp.obj[33].worldX = 31 * gp.tileSize;
        gp.obj[33].worldY = 19 * gp.tileSize;

        gp.obj[34] = new OBJ_GasPump();
        gp.obj[34].worldX = 215 * gp.tileSize;
        gp.obj[34].worldY = 13 * gp.tileSize;

        gp.obj[35] = new OBJ_GasPump();
        gp.obj[35].worldX = 11 * gp.tileSize;
        gp.obj[35].worldY = 150 * gp.tileSize;

        gp.obj[36] = new OBJ_GasPump();
        gp.obj[36].worldX = 22 * gp.tileSize;
        gp.obj[36].worldY = 133 * gp.tileSize;

        gp.obj[37] = new OBJ_GasPump();
        gp.obj[37].worldX = 99 * gp.tileSize;
        gp.obj[37].worldY = 127 * gp.tileSize;

        gp.obj[38] = new OBJ_GasPump();
        gp.obj[38].worldX = 214 * gp.tileSize;
        gp.obj[38].worldY = 127 * gp.tileSize;

        gp.obj[39] = new OBJ_GasPump();
        gp.obj[39].worldX = 21 * gp.tileSize;
        gp.obj[39].worldY = 87 * gp.tileSize;

        gp.obj[40] = new OBJ_GasPump();
        gp.obj[40].worldX = 20 * gp.tileSize;
        gp.obj[40].worldY = 51 * gp.tileSize;

        gp.obj[41] = new OBJ_GasPump();
        gp.obj[41].worldX = 14 * gp.tileSize;
        gp.obj[41].worldY = 33 * gp.tileSize;

        gp.obj[42] = new OBJ_GasPump();
        gp.obj[42].worldX = 197 * gp.tileSize;
        gp.obj[42].worldY = 33 * gp.tileSize;

        gp.obj[43] = new OBJ_GasPump();
        gp.obj[43].worldX = 224 * gp.tileSize;
        gp.obj[43].worldY = 45 * gp.tileSize;

        gp.obj[44] = new OBJ_GasPump();
        gp.obj[44].worldX = 224 * gp.tileSize;
        gp.obj[44].worldY = 81 * gp.tileSize;

        gp.obj[45] = new OBJ_GasPump();
        gp.obj[45].worldX = 233 * gp.tileSize;
        gp.obj[45].worldY = 159 * gp.tileSize;

        gp.obj[46] = new OBJ_GasPump();
        gp.obj[46].worldX = 233 * gp.tileSize;
        gp.obj[46].worldY = 155 * gp.tileSize;

        gp.obj[47] = new OBJ_GasPump();
        gp.obj[47].worldX = 173 * gp.tileSize;
        gp.obj[47].worldY = 164 * gp.tileSize;

        gp.obj[52] = new OBJ_Package(State.IN);
        gp.obj[52].worldX = 68 * gp.tileSize;
        gp.obj[52].worldY = 10 * gp.tileSize;

        gp.obj[16] = new OBJ_Package(State.OH);
        gp.obj[16].worldX = 108 * gp.tileSize;
        gp.obj[16].worldY = 8 * gp.tileSize;

        gp.obj[13] = new OBJ_Package(State.IL);
        gp.obj[13].worldX = 16 * gp.tileSize;
        gp.obj[13].worldY = 7 * gp.tileSize;

        gp.obj[15] = new OBJ_Package(State.KY);
        gp.obj[15].worldX = 37 * gp.tileSize;
        gp.obj[15].worldY = 80 * gp.tileSize;

        gp.obj[14] = new OBJ_Package(State.TN);
        gp.obj[14].worldX = 36 * gp.tileSize;
        gp.obj[14].worldY = 118 * gp.tileSize;

        gp.obj[18] = new OBJ_Package(State.MS);
        gp.obj[18].worldX = 14 * gp.tileSize;
        gp.obj[18].worldY = 170 * gp.tileSize;


        gp.obj[19] = new OBJ_Package(State.AL);
        gp.obj[19].worldX = 162 * gp.tileSize;
        gp.obj[19].worldY = 174 * gp.tileSize;
        gp.obj[49] = new OBJ_Package(State.GA);
        gp.obj[49].worldX = 194 * gp.tileSize;
        gp.obj[49].worldY = 180 * gp.tileSize;

        gp.obj[17] = new OBJ_Package(State.SC);
        gp.obj[17].worldX = 208 * gp.tileSize;
        gp.obj[17].worldY = 151 * gp.tileSize;

        gp.obj[50] = new OBJ_Package(State.NC);
        gp.obj[50].worldX = 226 * gp.tileSize;
        gp.obj[50].worldY = 122 * gp.tileSize;

        gp.obj[51] = new OBJ_Package(State.VA);
        gp.obj[51].worldX = 218 * gp.tileSize;
        gp.obj[51].worldY = 55 * gp.tileSize;

        gp.obj[48] = new OBJ_Package(State.MD);
        gp.obj[48].worldX = 209 * gp.tileSize;
        gp.obj[48].worldY = 26 * gp.tileSize;

        gp.obj[53] = new OBJ_Package(State.WV);
        gp.obj[53].worldX = 152 * gp.tileSize;
        gp.obj[53].worldY = 45 * gp.tileSize;
        createCash(54,55);
            }

    public void createCash(int startBound,int totalCoins){
        Random ran = new Random();
        for(int i = 0; i < totalCoins; i++,startBound++){
            int randomX = ran.nextInt(230) + 5;
            int randomY = ran.nextInt(170) + 5;
            gp.obj[startBound] = new OBJ_Cash();
            gp.obj[startBound].worldX = randomX * gp.tileSize;
            gp.obj[startBound].worldY = randomY * gp.tileSize;
        }
    }
}


