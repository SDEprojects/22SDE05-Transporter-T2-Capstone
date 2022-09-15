package com.tlglearning.controller;

import com.tlglearning.model.OBJ_Chest;
import com.tlglearning.model.OBJ_Door;
import com.tlglearning.model.OBJ_Key;

public class AssetSetter {

    GamePanelB gp;

    public AssetSetter(GamePanelB gp) {
        this.gp = gp;
    }

    public void setObject(){
        gp.obj[0] = new OBJ_Key();
        gp.obj[0].worldX = 40 * gp.tileSize;
        gp.obj[0].worldY = 40 * gp.tileSize;

        gp.obj[1] = new OBJ_Key();
        gp.obj[1].worldX = 20 * gp.tileSize;
        gp.obj[1].worldY = 20 * gp.tileSize;

        gp.obj[2] = new OBJ_Door();
        gp.obj[2].worldX = 25 * gp.tileSize;
        gp.obj[2].worldY = 25 * gp.tileSize;

        gp.obj[3] = new OBJ_Door();
        gp.obj[3].worldX = 30 * gp.tileSize;
        gp.obj[3].worldY = 30 * gp.tileSize;

        gp.obj[4] = new OBJ_Chest();
        gp.obj[4].worldX = 35 * gp.tileSize;
        gp.obj[4].worldY = 35 * gp.tileSize;
    }

}
