package org.example;

import java.util.Map;
import java.util.Random;

public class Items {

    private static final Random random = new Random();
    public static String generateRandomItem() {
        String[] items = {"Health Potion", "Throwing Axe", "Magic Amulet", "Shield"};
        int index = random.nextInt(items.length);
        return items[index];
    }
    public static void applyItemEffect(String item, Player player, Map<String, Integer> activeItemEffects) {
        int healthBonus = 0;
        int attackBonus = 0;
        int playerHealth = player.getHealth();
        int playerAttack = player.getAttack();

        if (item.equals("Health Potion")) {
            healthBonus = 20;
            player.increaseHealth(healthBonus);
            System.out.println("You consumed a Health Potion and gained " + healthBonus + " health. Your health is now " + playerHealth + ".");
        } else if (item.equals("Throwing Axe")) {
            attackBonus = 10;
            player.increaseAttack(attackBonus);
            System.out.println("You equipped a Throwing Axe and gained " + attackBonus + " attack. Your attack is now " + playerAttack + ".");
        } else if (item.equals("Magic Amulet")) {
            attackBonus = 20;
            player.increaseAttack(attackBonus);
            System.out.println("You equipped a Magic Amulet and gained " + attackBonus + " attack. Your attack is now " + playerAttack + ".");
        } else if (item.equals("Shield")) {
            healthBonus = 20;
            player.increaseHealth(healthBonus);
            System.out.println("You equipped a Shield and gained " + healthBonus + " health. Your health is now " + playerHealth + ".");
        }

        // Update the active item effects
        activeItemEffects.put(item, activeItemEffects.getOrDefault(item, 0) + 1);
    }

}
