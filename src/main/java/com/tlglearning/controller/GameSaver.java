package com.tlglearning.controller;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class GameSaver {
    private static GameSaver instance;
    private LinkedList<GameRecord> gameRecords;

    private GameSaver() throws IOException {
        TypeReference<LinkedList<GameRecord>> typeRef = new TypeReference<>() {
        };
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream actions = null;
        try {
            actions = new FileInputStream("records.json");
        } catch (IOException ignore) {

        }
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
        JsonFactory jsonFactory = new JsonFactory();
        jsonFactory.configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false);
        ObjectMapper mapper = new ObjectMapper(jsonFactory);
//        ObjectMapper mapper = new ObjectMapper();
//        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try {
            mapper.writeValue(
                    new File("records.json"), gameRecords);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
//    mapper.writeValue(
//            new FileOutputStream("src/main/resources/records.json"), gameRecords);

//    public String getTopRanks(int top){
//
//        Collections.sort(gameRecords);
//        StringBuilder sb = new StringBuilder();
//
//        for (GameRecord record : gameRecords){
//            sb.append(record);
//            if (--top == 0){
//                return sb.toString();
//            }
//        }
//        return sb.toString();
//    }
public ArrayList<GameRecord> getTopRanks(int num){

    int min = Math.min(gameRecords.size(), num);
    ArrayList<GameRecord> res = new ArrayList<>();
    Collections.sort(gameRecords);
    for (int i = 0; i < min; i++){
        res.add(gameRecords.get(i));
    }

    return res;
}



}