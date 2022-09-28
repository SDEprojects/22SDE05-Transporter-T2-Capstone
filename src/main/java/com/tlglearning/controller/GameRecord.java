package com.tlglearning.controller;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GameRecord implements Comparable<GameRecord>{
    private String playerName;
    private double playDuration;
    private double playerCash;
    private String gameDate;

    DecimalFormat df = new DecimalFormat("#0.00");

    public GameRecord(){
        this("", 0,0);
    }

    public GameRecord(String playerName, double playDuration, double playerCash){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        gameDate = formatter.format(now);
        this.playerName = playerName;
        this.playerCash = playerCash;
        this.playDuration = playDuration;
    }


    @Override
    public int compareTo(GameRecord other) {
        return Double.compare(playDuration, other.playDuration);
    }



    @Override
    public String toString() {
        return "Date: " + gameDate +
                " - Play Time: " + df.format(playDuration) + " seconds" + " - Cash: $" + df.format(playerCash);
    }


    public String getPlayerName() {
        return playerName;
    }

    public double getPlayDuration() {
        return playDuration;
    }
    public double getPlayerCash() {
        return playerCash;
    }

    public String getGameDate() {
        return gameDate;
    }



}