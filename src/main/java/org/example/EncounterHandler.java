package org.example;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EncounterHandler {
    public static void handleEncounter(int encounter, Player player, String roomDescription,
                                       List<String> inventory, Map<String, Integer> activeItemEffects,
                                       Map<String, Boolean> solvedPuzzles, Scanner scanner) {
        if (encounter == 1) {
            Monster monster = Monster.generateRandomMonster(roomDescription);
            BattleManager.startBattle(player, monster);
            if (player.isAlive()) {
                inventory.add(Items.generateRandomItem());
            }
        } else if (encounter == 2) {
            String item = Items.generateRandomItem();
            inventory.add(item);
            System.out.println("You found a " + item + " and added it to your inventory.");
            Items.applyItemEffect(item, player, activeItemEffects);
        } else if (encounter == 3) {
            String puzzleKey = Puzzles.generateRandomPuzzleKey();
            boolean puzzleSolved = Puzzles.solvePuzzle(scanner, puzzleKey);
            if (!solvedPuzzles.containsKey(puzzleKey) || !solvedPuzzles.get(puzzleKey)) {
                if (puzzleSolved) {
                    System.out.println("Congratulations! You solved the puzzle and unlocked the door.");
                    solvedPuzzles.put(puzzleKey, true);
                } else {
                    System.out.println("Oops! You failed to solve the puzzle.");
                    player.decreaseHealth(50); // Deduct health as a penalty for failing the puzzle
                    System.out.println("You lost 50 health points.");
                }
            } else {
                System.out.println("You enter a room with an already solved puzzle. There is nothing to do here.");
            }
        } else {
            System.out.println("You found nothing in this room.");

            // Other methods (generateRandomRoomDescription, Monster generation, item effects, etc.) go here
        }
    }
}
