package com.tlglearning.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.LinkedList;

public class GameSaver {
    private static GameSaver instance;
    private LinkedList<GameRecord> gameRecords;

    private GameSaver() throws IOException {
        TypeReference<LinkedList<GameRecord>> typeRef = new TypeReference<>() {};
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream actions = classLoader.getResourceAsStream("records.json");
        gameRecords = new ObjectMapper().readValue(actions, typeRef);
    }

    public static GameSaver getInstance() throws IOException {
        if (instance == null){
            instance = new GameSaver();
        }
        return instance;
    }

    public void addRecord(GameRecord record){
        gameRecords.add(record);
    }

    public void saveToJSON() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(
                    new FileOutputStream("src/main/resources/records.json"), gameRecords);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String getTopRanks(int top){

        Collections.sort(gameRecords);
        StringBuilder sb = new StringBuilder();

        for (GameRecord record : gameRecords){
            sb.append(record);
            if (--top == 0){
                return sb.toString();
            }
        }
        return sb.toString();
    }



}