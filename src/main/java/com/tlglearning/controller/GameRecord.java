package com.tlglearning.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GameRecord implements Comparable<GameRecord>{
    private String playerName;
    private float playTime;

    private String gameDate;


    public GameRecord(){
        this("", 0);
    }

    public GameRecord(String playerName, float playTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        gameDate = formatter.format(now);
        this.playerName = playerName;
        this.playTime = playTime;
    }


    @Override
    public int compareTo(GameRecord other) {
        return (int) ((int) playTime - other.playTime);
    }


    @Override
    public String toString() {
        return "GameRecord{" +
                "playerName='" + playerName + '\'' +
                ", playTime=" + playTime +
                ", gameDate=" + gameDate +
                '}';
    }

    public String getPlayerName() {
        return playerName;
    }



    public String getGameDate() {
        return gameDate;
    }
}
