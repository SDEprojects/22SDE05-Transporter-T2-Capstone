package com.tlglearning.model;

import com.tlglearning.controller.GamePanelB;
import com.tlglearning.controller.KeyHandlerB;
import com.tlglearning.model.objects.OBJ_Package;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import static org.junit.Assert.*;

class PlayerTest {
    private static Set<State> destinations;
    private static double playerMoney;
    private static Player player;
    private LinkedList<OBJ_Package> packagesInTrunck;

    @BeforeAll
    static void setUp() {
        destinations = new HashSet<>();
        destinations.add(State.MS);
        destinations.add(State.IL);
        destinations.add(State.KY);
        playerMoney = 200;
        player = new Player(new GamePanelB(), new KeyHandlerB());


    }

    @Test
    void setDestinations() {
        assertTrue(destinations.contains(State.IL));
    }

    @Test
    void getPlayerMoney() {
        assertEquals(200, playerMoney, 0);
    }


    @Test
    void getNextDestination(){
        State destination = player.getNextDestination();
        assertFalse(State.MS.equals(destination));
    }

    @Test
    void getPackagesDelivered() {
        assertEquals(0, player.getPackagesDelivered());
    }

    @Test
    void removeDestination1() {
        assertTrue(player.removeDestination(State.VA));

    }

    @Test
    void removeDestination2() {
        assertFalse(player.removeDestination(State.MS));

    }
}