package com.tlglearning.model;

import javax.imageio.ImageIO;

public class InventoryBar extends SuperObject {
    public InventoryBar() {
        name = "Inventory";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/inventory_bg.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

