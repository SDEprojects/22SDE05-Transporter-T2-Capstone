package com.controller;

import com.tlglearning.controller.GameRecord;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GameRecordTest {

    private static GameRecord record1;
    private static GameRecord record2;

    @BeforeAll
    static void setUp() {
        record1 = new GameRecord("Rob", 41.2, 20);
        record2 = new GameRecord("Blair", 41.1, 20);
    }
    @Test
    void compareTo() {
        int value = record1.compareTo(record2);
        assertTrue(value > 0);
    }
    @Test
    void getCash() {
        assertTrue(record1.getPlayerCash() == 20);
    }

    @Test
    void getGameDate() {

        assertTrue(record1.getGameDate() != null);
    }



}