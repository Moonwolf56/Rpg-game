package org.example;

import java.util.Random;
import java.util.Scanner;

public class Puzzles {

    private static Random random = new Random();

    public static String generateRandomPuzzleKey() {
        String[] puzzleKeys = {"puzzle1", "puzzle2", "puzzle3"};
        int index = random.nextInt(puzzleKeys.length);
        return puzzleKeys[index];
    }

    public static boolean solvePuzzle(Scanner scanner, String puzzleKey) {
        switch (puzzleKey) {
            case "puzzle1": {
                System.out.println("You enter a room with a mysterious inscription on the wall.");
                System.out.println("The inscription reads: 'I speak without a mouth and hear without ears. I have no body, but I come alive with the wind. What am I?'");
                System.out.print("Your answer: ");
                scanner.nextLine(); // Consume the newline character

                String answer = scanner.nextLine().trim().toLowerCase();
                return answer.equals("an echo");
            }
            case "puzzle2": {
                System.out.println("You enter a room with a riddle carved into the stone floor.");
                System.out.println("The riddle asks: 'I'm not alive, but I can grow; I don't have lungs, but I need air; I don't have a mouth, but water kills me. What am I?'");
                System.out.print("Your answer: ");
                scanner.nextLine(); // Consume the newline character

                String answer = scanner.nextLine().trim().toLowerCase();
                return answer.equals("fire");
            }
            case "puzzle3":
                System.out.println("You find a room with an ancient puzzle.");
                System.out.println("The puzzle presents a sequence: 2, 4, 8, 16, ____. What number comes next?");
                System.out.print("Your answer: ");
                int userAnswer = scanner.nextInt();
                return userAnswer == 32;
        }
        return false;
    }
}
