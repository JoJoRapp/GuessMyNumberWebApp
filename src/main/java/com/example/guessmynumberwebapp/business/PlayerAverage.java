package com.example.guessmynumberwebapp.business;

public class PlayerAverage{
    private final String playerName;
    private final double average;

    public PlayerAverage(String playerName, double average) {
        this.playerName = playerName;
        this.average = average;
    }

    public String getPlayerName() {
        return playerName;
    }

    public double getAverage() {
        return average;
    }
}
