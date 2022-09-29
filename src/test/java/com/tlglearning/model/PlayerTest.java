package com.tlglearning.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class PlayerTest {
    private static Set<State> destinations;
    private static double playerMoney;

    @BeforeAll
    static void setUp() {
        destinations = new HashSet<>();
        destinations.add(State.IL);
        destinations.add(State.KY);
        playerMoney = 200;

    }

    @Test
    void setDestinations() {
        assertTrue(destinations.contains(State.IL));
    }

    @Test
    void getPlayerMoney() {
        assertEquals(200, playerMoney, 0);
    }
}