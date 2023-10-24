package org.example;

import java.util.*;

import static org.example.Rooms.generateRandomRoomDescription;

public class DungeonGame {
    public static void HandelGameUI() {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            Player player = Player.createPlayer(scanner);
            int numMonsters = 4;
            int monstersDefeated = 0;
            int playerHealth = player.getHealth();
            int playerAttack = player.getAttack();
            List<String> inventory = new ArrayList<>();
            Map<String, Integer> activeItemEffects = new HashMap<>();
            Map<String, Boolean> solvedPuzzles = new HashMap<>();

            System.out.println("Welcome to the Dungeon!");
            System.out.println("You have " + playerHealth + " health and " + playerAttack + " attack.");

            int playerChoice;
            boolean playerEscaped = false;

            while (playerHealth > 0 && monstersDefeated < numMonsters && !playerEscaped) {
                String roomDescription = generateRandomRoomDescription();
                System.out.println("\nYou enter: \n" + roomDescription);
                System.out.println("1. Explore");
                System.out.println("2. Run");
                System.out.println("3. Check Health");

                playerChoice = getPlayerChoice(scanner);

                switch (playerChoice) {
                    case 1:
                        int encounter = getRandomEncounter();
                        EncounterHandler.handleEncounter(encounter, player, roomDescription, inventory, activeItemEffects, solvedPuzzles, scanner);

                        if (encounter == 1 && playerHealth > 0) {
                            monstersDefeated++;
                        }
                        break;
                    case 2:
                        playerEscaped = true;
                        break;
                    case 3:
                        System.out.println("Your current health is: " + playerHealth);
                        break;
                    default:
                        System.out.println("Invalid choice! Please choose 1, 2, or 3.");
                }
            }

            if (playerEscaped) {
                System.out.println("\nYou are a coward! And ran away.");
            } else if (playerHealth > 0 && monstersDefeated == numMonsters) {
                BattleManager.startBossBattle(scanner, player, playerAttack);
            } else {
                System.out.println("\nGame over! You did not make it out of the dungeon.");
            }

            // Display inventory and active item effects
            System.out.println("Your inventory contains:");
            for (String item : inventory) {
                System.out.println(item);
            }

            System.out.println("\nActive Item Effects:");
            for (Map.Entry<String, Integer> entry : activeItemEffects.entrySet()) {
                System.out.println(entry.getKey() + " (Active: " + entry.getValue() + ")");
            }

            System.out.println("\nDo you want to play again? (1. Yes / 2. No)");
            int playAgainChoice = getPlayerChoice(scanner);
            if (playAgainChoice != 1) {
                playAgain = false;
            }
        }

        System.out.println("Thank you for playing!");
    }
    private static int getRandomEncounter() {
        return new Random().nextInt(4); // 0: No encounter, 1: Monster, 2: Item, 3: Puzzle
    }
    private static int getPlayerChoice(Scanner scanner) {
        int choice;
        while (true) {
            try {
                choice = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // Clear the invalid input from the scanner
            }
        }
        return choice;
    }

}
