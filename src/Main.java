import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // System objects //
        Scanner in = new Scanner(System.in);
        // Random number object generator
        Random rand = new Random();

        // Game Variables //
        // Enemies variable, string array
        String[] enemies = {"Bat", "Ghoul", "Goblin", "Necromancer"};
        // Enemy Health Variable
        int maxEnemyHealth = 75;
        // Enemy Attack Damage Variable
        int enemyAttackDamage = 25;

        // Player Variables //
        int health = 100;
        int attackDamage = 50;
        int numHealthPotions = 4;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50; // 50 Percent chance to drop a health potion

        // Running Variable, game keeps running unless there is a condition for it to stop (while loop)
        boolean running = true;

        System.out.println("Welcome to the Dark Forest!");
        // GAME is the label of the while loop
        GAME:
        while (running) {
            System.out.println("----------------------");
            // Start Combat with Enemy, uses random generator, picks number from 1 to maxEnemyHealth variable, in this case 75
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            // Random enemy generated
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " appeared! #\n");
            //  # Ghoul has appeared! #

            // Give player options while enemy is alive
            while (enemyHealth > 0) {
                System.out.println("\tYour HP: " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1 Attack");
                System.out.println("\t2 Drink Health Potion");
                System.out.println("\t3 Run!");

                // Get users input
                String input = in.nextLine();
                if (input.equals("1")) {
                    // generate random damage between 1 & 50
                    int damageDealt = rand.nextInt(attackDamage);
                    //  generate random damage taken
                    int damageTaken = rand.nextInt(enemyAttackDamage);
                    // Take the damage off
                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    // Attack print
                    System.out.println("\t> You attack " + enemy + " for" + damageDealt + " damage.");
                    System.out.println("\t> You receive " + damageTaken);

                    // Health Low Print
                    if(health < 1) {
                        System.out.println("\t> You have taken too much damage to continue!");


                    }

                } else if (input.equals("2")) {

                } else if (input.equals("3")) {

                } else {

                }
            }
        }
    }
}

