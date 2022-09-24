package com.tlglearning.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GameRecord implements Comparable<GameRecord>{
    private String playerName;
    private double playDuration;

    private String gameDate;


    public GameRecord(){
        this("", 0);
    }

    public GameRecord(String playerName, double playDuration){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        gameDate = formatter.format(now);
        this.playerName = playerName;
        this.playDuration = playDuration;
    }


    @Override
    public int compareTo(GameRecord other) {
        return Double.compare(playDuration, other.playDuration);
    }


    @Override
    public String toString() {
        return "GameRecord{" +
                "playerName='" + playerName + '\'' +
                ", playTime=" + playDuration +
                ", gameDate=" + gameDate +
                '}';
    }

    public String getPlayerName() {
        return playerName;
    }

    public double getPlayDuration() {
        return playDuration;
    }

    public String getGameDate() {
        return gameDate;
    }
}