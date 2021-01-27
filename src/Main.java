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
                    System.out.println("\t> You attack " + enemy + " for " + damageDealt + " damage.");
                    System.out.println("\t> You receive " + damageTaken);

                    // Health Low Print
                    if (health < 1) {
                        System.out.println("\t> You have taken too much damage to continue!");
                        break;
                    }
                    // Drink Health Potion //
                } else if (input.equals("2")) {
                    // check for health potion
                    if (numHealthPotions > 0) {
                        // Add to your health
                        health += healthPotionHealAmount;
                        // Take one health potion away
                        numHealthPotions--;
                        System.out.println("\t> YOu drink a health potion, +" + healthPotionHealAmount + "." + "\n\t> You now have " + health + " HP" + "\n\t> You have " + numHealthPotions + " Health potions left.\n");
                    } else {
                        // no health potions
                        System.out.println("\t> You have no health potions left, defeat enemies to try and recover one!");
                    }
                    // For running away //
                } else if (input.equals("3")) {
                    System.out.println("\t> You ran away from the " + enemy + "!");
                    continue GAME; // goes back to start of loop (GAME) if running away is true
                } else {
                    // If user enters something else
                    System.out.println("\tInvalid command.");
                }
            }
            // Health gets too low //
            if (health < 1) {
                System.out.println("You have been slain....");
                break;
            }

            System.out.println("----------------------");
            // if enemy was defeated (health was not too low
            System.out.println(" # " + enemy + " was defeated! #");
            System.out.println(" # You have " + health + " HP left. #");
            // If enemy drops a health potion after being defeated (50% chance)
            if(rand.nextInt(100) < healthPotionDropChance) {
                numHealthPotions++;
                System.out.println(" # The " + enemy + " dropped a health potion. # ");
                System.out.println(" # You have " + numHealthPotions + " health potion(s).");
            }
            System.out.println("----------------------");
            // Next Adventure Options
            System.out.println("What would you like to do?");
            System.out.println("1. Continue fighting.");
            System.out.println("2. Leave the Dark Forest.");

            // Run loop based on user's input
            String input = in.nextLine();
            // If player input is not 1 or 2
            while(!input.equals("1") && !input.equals("2")) {
                System.out.println("Invalid command!");
                input = in.nextLine();
            }
            // If player chooses 1 or 2
            if(input.equals("1")) {
                System.out.println("You continue further into the Forest.....");
            } else if(input.equals("2")) {
                System.out.println("You left the Dark Forest.");
                break;
            }
        }
        System.out.println("#########################");
        System.out.println(" # THANKS FOR PLAYING! # ");
        System.out.println("#########################");
    }
}

