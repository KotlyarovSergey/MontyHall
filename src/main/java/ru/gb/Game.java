package ru.gb;

public class Game {
    private int prize;
    private int firstChoise;
    private int opened;
    private int secondChoise;

    public Game(int prize, int firstChoise, int opened, int secondChoise) {
        this.prize = prize;
        this.firstChoise = firstChoise;
        this.opened = opened;
        this.secondChoise = secondChoise;
    }

    public int getPrize() {
        return prize;
    }

    public int getFirstChoise() {
        return firstChoise;
    }

    public int getOpened() {
        return opened;
    }

    public int getSecondChoise() {
        return secondChoise;
    }
}