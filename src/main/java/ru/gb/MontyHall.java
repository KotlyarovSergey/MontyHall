package ru.gb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.apache.commons.math3.stat.StatUtils;


public class MontyHall {
    private static int ROUNDS = 1000;

    public static void main(String[] args) {
        List<Game> games = new ArrayList<>(ROUNDS);
        Random rnd = new Random();

        int count = ROUNDS;
        while (count-- > 0) {
            int prize = rnd.nextInt(3);
            int firstChoise = rnd.nextInt(3);
            int opened = opened(prize, firstChoise);
            int secondChoise = secondChoise(firstChoise, opened);

            games.add(new Game(prize, firstChoise, opened, secondChoise));
        }

        printStatistics(games);
        System.out.println("\n");


        System.out.println("----StatUtils----");
        double[] mass = new double[]{1.5, 2.8, 5.6, 4.3, 1.2, 8.6, 3.5};
        System.out.println(Arrays.toString(mass));
        System.out.printf("max: %s\n", StatUtils.max(mass));
        System.out.printf("sum: %s\n", StatUtils.sum(mass));

    }

    private static void printStatistics(List<Game> games){
        int wins = 0;
        for (Game game : games) {
            if(game.getPrize() == game.getSecondChoise())
                wins++;
        }
        System.out.printf("win: %s, lose: %s\n", wins, games.size() - wins);
        System.out.printf("Percent of wins: %.1f%%\n", (double)wins / games.size() * 100);
    }


    private static int opened(int prize, int choise) throws RuntimeException {
        for (int i = 0; i < 3; i++)
            if (i != prize && i != choise)
                return i;

        throw new RuntimeException(String.format("Opened is failure! prize: %s, choise: %s", prize, choise));
    }

    private static int secondChoise(int firstChoise, int opened) {
        for (int i = 0; i < 3; i++)
            if (i != firstChoise && i != opened)
                return i;

        throw new RuntimeException(
                String.format("SecondChoise if failure! first: %s, opened: %s", firstChoise, opened));
    }
}
