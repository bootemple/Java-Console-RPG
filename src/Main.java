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
                    System.out.println("\t>1 You attack " + enemy + " for " + damageDealt + " damage.");
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
                        System.out.println("\t> YOu drink a health potion, +" + healthPotionHealAmount + "." + "\n\t> You now have " + health + " HP" + "\n\t> You have " +                            numHealthPotions + " Health potions left.\n");
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
        // Leaving Game
        System.out.println("#########################");
        System.out.println(" # THANKS FOR PLAYING! # ");
        System.out.println("#########################");
    }
}
//
//import java.util.Random;
//        import java.util.Scanner;
//
//public class ConsoleAdventureGame {
//    public static void main(String[] args) {
//
//
//        // System objects //
//        Scanner in = new Scanner(System.in);
//        // Random number object generator
//        Random rand = new Random();
//
//
//        // Game Variables //
//        // Enemies variable, string array
//        String[] enemies = {"Donkey", "A Cat With a Sword", "Lord Farquaad", "Fairy Godmother", "Dragon"};
//        String[] enemyAttacks = {"Bites", "Stabs", "Tortures", "Curses", "Scorches"};
//
//        // Enemy Health Variable
//        int maxEnemyHealth = 75;
//        // Enemy Attack Damage Variable
//        int enemyAttackDamage = 25;
//
//
//        // Player Variables //
//        int health = 100;
//        int attackDamage = 50;
//        int numHealthPotions = 4;
//        int healthPotionHealAmount = 30;
//        int healthPotionDropChance = 50; // 50 Percent chance to drop a health potion
//        int swordDropChance = 50;
//
//        // Running Variable, game keeps running unless there is a condition for it to stop (while loop)
//        boolean running = true;
//
//        System.out.println("♞ Welcome to the Swamp! ♞");
//        // GAME is the label of the while loop
//        GAME:
//        while (running) {
//            System.out.println("----------------------");
//            // Start Combat with Enemy, uses random generator, picks number from 1 to maxEnemyHealth variable, in
//            // this case 75
//            int enemyHealth = rand.nextInt(maxEnemyHealth);
//            // Random enemy generated
//            int enemySelector = rand.nextInt(enemies.length);
//            String enemy = enemies[enemySelector];
//            String enemyAttack = enemyAttacks[enemySelector];
//            System.out.println("\t# " + enemy + " appeared! #\n");
//            //  # Ghoul has appeared! #
//
//            // Give player options while enemy is alive
//            while (enemyHealth > 0) {
//                System.out.println("\tYour HP: " + health);
//                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
//                System.out.println("\n\tWhat would you like to do?");
//                System.out.println("\t1 Attack");
//                System.out.println("\t2 Drink Health Potion");
//                System.out.println("\t3 Run!");
//
//                // Get users input
//                String input = in.nextLine();
//                if (input.equals("1")) {
//                    // generate random damage between 1 & 50
//                    int damageDealt = rand.nextInt(attackDamage);
//                    //  generate random damage taken
//                    int damageTaken = rand.nextInt(enemyAttackDamage);
//                    // Take the damage off
//                    enemyHealth -= damageDealt;
//
//                    // Attack print
//                    System.out.println("\t>1 You attack " + enemy + " for " + damageDealt + " damage.");
//
//                    if (enemyHealth <= 0) {
//                        System.out.println(" # " + enemy + " was defeated! #");
//
//                        if (rand.nextInt(100) < healthPotionDropChance) {
//                            if (numHealthPotions < 4) {
//                                numHealthPotions++;
//                                System.out.println(" # The " + enemy + " dropped a health potion. # ");
//                                System.out.println(" # You have " + numHealthPotions + " health potion(s).");
//                            } else {
//                                System.out.println(" # The " + enemy + " dropped a health potion. # ");
//                                System.out.println(" # Your pack is full! # ");
//                            }
//                            if (rand.nextInt(100) < swordDropChance) {
//                                attackDamage = attackDamage + 5;
//                                System.out.println(" # You leveled up. # ");
//                                System.out.println(" # Your base attack is  " + attackDamage);
//                            }
//                        }
//                        break;
//                    }
//                    health -= damageTaken;
//                    System.out.println("\t>" + enemy + " " + enemyAttack + " you! You take " + damageTaken + " damage" +
//                            "!");
//
//                    // Health Low Print
//                    if (health < 1) {
//
//                        System.out.println("\t> You have taken too much damage to continue!");
//                        break;
//                    }
//                    // Drink Health Potion //
//                } else if (input.equals("2")) {
//                    // check for health potion
//                    if (health == 100) {
//                        System.out.println("Your health is Full!");
//
//                        int damageTaken = rand.nextInt(enemyAttackDamage);
//
//                        health -= damageTaken;
//                        System.out.println("\t>" + enemy + " " + enemyAttack + " you! You take " + damageTaken + " damage" +
//                                "!");
//                        if (health < 1) {
//
//                            System.out.println("\t> You have taken too much damage to continue!");
//                            break;
//                        }
//                    } else if (numHealthPotions > 0) {
//                        // Add to your health
//                        int actualHeal = healthPotionHealAmount;
//                        if (health + healthPotionHealAmount > 100) {
//                            actualHeal = 100 - health;
//                            health = 100;
//
//                        } else {
//                            health += healthPotionHealAmount;
//                        }
//                        // Take one health potion away
//                        numHealthPotions--;
//                        System.out.println("\t> You drink a health potion, +" + actualHeal + "." + "\n\t>" +
//                                " You now have " + health + " HP" + "\n\t> You have " + numHealthPotions + " Health " +
//                                "potions left.\n");
//
//
////                        ENEMY ATTACK
//                        int damageTaken = rand.nextInt(enemyAttackDamage);
//
//                        health -= damageTaken;
//                        System.out.println("\t>" + enemy + " " + enemyAttack + " you! You take " + damageTaken + " damage" +
//                                "!");
//                        if (health < 1) {
//
//                            System.out.println("\t> You have taken too much damage to continue!");
//                            break;
//                        }
//                    } else {
//                        // no health potions
//                        System.out.println("\t> You have no health potions left, defeat enemies to try and recover " +
//                                "one!");
//                    }
//                    // For running away //
//                } else if (input.equals("3")) {
//                    System.out.println("\t> You ran away from the " + enemy + "!");
//                    break;
//                } else {
//                    // If user enters something else
//                    System.out.println("\tInvalid command.");
//                }
//            }
//
//
//            // Health gets too low //
//            if (health < 1) {
//                System.out.println();
//                System.out.println("             ,-'     `._ \n" +
//                        "                 ,'           `.        ,-. \n" +
//                        "               ,'               \\       ),.\\ \n" +
//                        "     ,.       /                  \\     /(  \\; \n" +
//                        "    /'\\\\     ,o.        ,ooooo.   \\  ,'  `-') \n" +
//                        "    )) )`. d8P\"Y8.    ,8P\"\"\"\"\"Y8.  `'  .--\"' \n" +
//                        "   (`-'   `Y'  `Y8    dP       `'     / \n" +
//                        "    `----.(   __ `    ,' ,---.       ( \n" +
//                        "           ),--.`.   (  ;,---.        ) \n" +
//                        "          / \\O_,' )   \\  \\O_,'        | \n" +
//                        "         ;  `-- ,'       `---'        | \n" +
//                        "         |    -'         `.           | \n" +
//                        "        _;    ,            )          : \n" +
//                        "     _.'|     `.:._   ,.::\" `..       | \n" +
//                        "  --'   |   .'     \"\"\"         `      |`. \n" +
//                        "        |  :;      :   :     _.       |`.`.-'--. \n" +
//                        "        |  ' .     :   :__.,'|/       |  \\ \n" +
//                        "        `     \\--.__.-'|_|_|-/        /   ) \n" +
//                        "         \\     \\_   `--^\"__,'        ,    | \n" +
//                        "   -hrr- ;  `    `--^---'          ,'     | \n" +
//                        "          \\  `                    /      / \n" +
//                        "           \\   `    _ _          / \n" +
//                        "            \\           `       / \n" +
//                        "             \\           '    ,' \n" +
//                        "              `.       ,   _,' \n" +
//                        "                `-.___.---' ");
//                System.out.println("#########################");
//                System.out.println(" # You have been slain # ");
//                System.out.println("#########################");
//                System.out.println(" # This is my swamp # ");
//                System.out.println("#########################");
//                break;
//            }
//
//            System.out.println("----------------------");
//
//            System.out.println(" # You have " + health + " HP left. #");
//
//
//            System.out.println("----------------------");
//            // Next Adventure Options
//            System.out.println("What would you like to do?");
//            System.out.println("1. Continue fighting.");
//            System.out.println("2. Leave the Swamp.");
//
//            // Run loop based on user's input
//            String input = in.nextLine();
//            // If player input is not 1 or 2
//            while (!input.equals("1") && !input.equals("2")) {
//                System.out.println("Invalid command!");
//                input = in.nextLine();
//            }
//            // If player chooses 1 or 2
//            if (input.equals("1")) {
//                System.out.println("You continue further into the Swamp.....");
//            } else if (input.equals("2")) {
//                System.out.println("You left the Swamp....");
//                break;
//            }
//        }
//        // Leaving Game
//        System.out.println("#########################");
//        System.out.println(" # THANKS FOR PLAYING! # ");
//        System.out.println("#########################");
//    }
//
//}