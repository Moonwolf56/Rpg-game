package org.example;

import java.util.Scanner;

public class Player {
    private String name;
    private int health;
    private int attack;

    public Player(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public void decreaseHealth(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0; // Ensure health doesn't go negative
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    // Method to increase player's health
    public void increaseHealth(int bonusHealth) {
        health += bonusHealth;
    }

    // Method to increase player's attack
    public void increaseAttack(int bonusAttack) {
        attack += bonusAttack;
    }

    public static Player createPlayer(Scanner scanner) {
        System.out.print("Enter player name: ");
        String name = scanner.nextLine().trim();
        return new Player(name, 300, 25);
    }
}
