package org.example;

 class Monster {
    private static String name;
    private int health;
    private int attack;

    public Monster(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    public static String getName() {
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
    }
     public boolean isAlive() {
         return health > 0;
     }

     public static Monster generateRandomMonster(String roomDescription) {
         if (roomDescription.contains("spiders")) {
             return new Monster("Giant Spider", 40, 15);
         } else if (roomDescription.contains("mushrooms")) {
             return new Monster("Fungal Beast", 50, 20);
         } else if (roomDescription.contains("tombs")) {
             return new Monster("Restless Spirit", 45, 18);
         } else {
             return new Monster("Unknown Monster", 35, 12);
         }
     }

     static Monster generateBoss() {
         return new Monster("Fenrir", 200, 30); // The boss is named Fenrir, a giant wolf
     }

 }