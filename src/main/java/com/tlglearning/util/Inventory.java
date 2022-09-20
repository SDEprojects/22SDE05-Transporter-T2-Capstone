package main.java.com.tlglearning.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Inventory {

    private static final ArrayList<String> backpack = new ArrayList<>();

    private static final Set<String> backpackItems = new HashSet<>();
    //ctor

    public Inventory() {
    }

    //allows methods to access current backpack items
    public static ArrayList<String> getBackpack() {
        return backpack;
    }

    public Object addItem(String item) {
        if(!backpackItems.contains(item)){
            backpack.add(item);
            backpackItems.add(item);
        }
        return null;
    }
}
