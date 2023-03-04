//package com.oasis;

import java.util.Scanner;
import java.util.Random;

class NumberGame {
    private int guessedNumber, chances, points;
    private final int generatedNumber;

    NumberGame() {
        Random rn = new Random();
        generatedNumber = rn.nextInt(100);
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setChances(int chances) {
        this.chances = chances;
    }

    public int getChances() {
        return chances;
    }

    public void setGuessedNumber(int guessedNumber) {
        this.guessedNumber = guessedNumber;
    }

    public boolean guessIt() {
        if (chances == 9) {
            chances++;
            return false;
        }

        // Cheat Code
        else if (guessedNumber == -1) {
            System.out.println("Cheat activated! The generated code is " + generatedNumber);
            return false;
        }
        else if (generatedNumber == guessedNumber) {
            System.out.println("You Guessed it Right :)");
            System.out.println("Your Score is:" + (10 - points) * 10);
            System.out.println("The answer is " + generatedNumber);
            return true;
        }
        else if (generatedNumber < guessedNumber) {
            System.out.println("You guessed more!");
            chances++;
            points++;
            System.out.println((10 - chances) + " chances left");
            return false;
        }
        else {
            System.out.println("You guessed less!");
            chances++;
            points++;
            System.out.println((10 - chances) + " chances left");
            return false;
        }
    }
}

public class GuessTheNumberGame {
    public static void main(String[] args) {
        NumberGame game = new NumberGame();
        Scanner sc = new Scanner(System.in);
        int playmore = 1;
        System.out.println("-----Guess the Number Game-----");
        boolean exit_var = false;
        while (playmore != 0) {
            System.out.println("1. Play");
            System.out.println("2. Quit");
            System.out.println("Enter your choice:");
            playmore = sc.nextInt();
            switch (playmore) {
                case 1 -> {
                    while (!exit_var) {
                        System.out.println("Enter a number!");
                        game.setGuessedNumber(sc.nextInt());
                        exit_var = game.guessIt();
                        if (game.getChances() == 10) {
                            System.out.println("Sorry you lost :(");
                            break;
                        }
                    }
                    game.setChances(0);
                    game.setPoints(0);
                    System.out.println("----------------------------------------------------");
                }
                case 2 -> {
                    System.out.println("Quiting!");
                    playmore = 0;
                }
                default -> System.out.println("Invalid! Enter again");
            }
        }
    }
}
