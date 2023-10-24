package org.example;

import java.util.Random;
import java.util.Scanner;

public class BattleManager {
    private static final Random random = new Random();

    public static void startBattle(Player player, Monster monster) {
        System.out.println("A " + monster.getName() + " emerges with " + monster.getHealth() + " health and " + monster.getAttack() + " attack!");

        while (player.isAlive() && monster.isAlive()) {
            // Player's turn
            playerTurn(player, monster);

            if (!monster.isAlive()) {
                System.out.println("You defeated the " + monster.getName() + "!");
                break;
            }

            // Monster's turn
            monsterTurn(player, monster);

            if (!player.isAlive()) {
                System.out.println("You were defeated by the " + monster.getName() + ".");
                break;
            }
        }
    }

    private static void playerTurn(Player player, Monster monster) {
        Scanner scanner = new Scanner(System.in);
        int choice = getPlayerChoice(scanner); // Simulate player input

        if (choice == 1) {
            int playerDamage = random.nextInt(player.getAttack());
            String attackDescription = getRandomAttackDescription();
            System.out.println(attackDescription);
            int monsterDamage = random.nextInt(monster.getAttack());
            String hitDescription = getRandomHitDescription();
            System.out.println(hitDescription);

            monster.decreaseHealth(playerDamage);
            player.decreaseHealth(monsterDamage);

            System.out.println("You dealt " + playerDamage + " damage to the " + monster.getName() + ".");
            System.out.println("The " + monster.getName() + " dealt " + monsterDamage + " damage to you.");
        } else {
            System.out.println("You ran away from the battle.");
        }
    }

    public static void startBossBattle(Scanner scanner, Player player, int playerAttack) {
        Monster boss = Monster.generateBoss();
        System.out.println("\nYou've cleared all the rooms! Now, you enter the Boss Room!");
        System.out.println("You enter a vast chamber, and there stands " + boss.getName() + ", a giant wolf with " + boss.getHealth() + " health and " + boss.getAttack() + " attack!");

        while (player.isAlive() && boss.isAlive()) {
            int battleChoice = getPlayerChoice(scanner);
            if (battleChoice == 1) {
                // Player attacks
                int playerDamage = random.nextInt(playerAttack);
                int bossDamage = random.nextInt(boss.getAttack());
                boss.decreaseHealth(playerDamage);
                player.decreaseHealth(bossDamage);
                System.out.println("You dealt " + playerDamage + " damage to " + boss.getName() + ".");
                System.out.println(boss.getName() + " dealt " + bossDamage + " damage to you.");
            } else if (battleChoice == 2) {
                System.out.println("You ran away from the battle.");
                break;
            }
        }

        if (!player.isAlive()) {
            System.out.println("You were defeated by the final boss, " + boss.getName() + ".");
        } else {
            System.out.println("Congratulations! You defeated the final boss, " + boss.getName() + ", and won the game!");
        }
    }

    private static int getPlayerChoice(Scanner scanner) {
        System.out.println("1. Attack");
        System.out.println("2. Run");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    private static void monsterTurn(Player player, Monster monster) {
        int monsterDamage = random.nextInt(monster.getAttack());
        String hitDescription = getRandomHitDescription();
        System.out.println(hitDescription);

        player.decreaseHealth(monsterDamage);

        System.out.println("The " + monster.getName() + " dealt " + monsterDamage + " damage to you.");
    }

    private static String getRandomAttackDescription() {
        String[] attackDescriptions = {"You strike ferociously!", "Your attack lands a solid hit!", "A swift blow from your weapon!", "You attack with determination!"};
        return attackDescriptions[random.nextInt(attackDescriptions.length)];
    }

    private static String getRandomHitDescription() {
        String[] hitDescriptions = {"The monster's attack grazes you!", "You feel a sharp pain as the monster strikes!", "The attack lands, causing discomfort!", "A powerful blow hits you!"};
        return hitDescriptions[random.nextInt(hitDescriptions.length)];
    }
}
