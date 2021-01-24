package TextRPG;

import java.util.Scanner;

public class GameLogic {
    // scan for user input
    static Scanner scanner = new Scanner(System.in);

    static Player player;

    public static boolean isRunning;
    // Story Elements
    public static int place = 0, act;
    public static String[] places = {"Everlasting Mountains", "Haunted Forest", "The last of his kind", "The holy staff"};

    // Method to get user input from console
    public static int readInt(String prompt, int userChoices) {
        // do while loop
        int input;
        do {
            // use try catch statement in case something goes wrong
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            }catch(Exception e) {
                input = -1;
                // if player enters something other than a number
                System.out.println("Please enter an integer!");
            }
        } while (input < 1);
        return input;
    }
    // method to simulate clearing out the console
    public static void clearConsole() {
        for(int i = 0; i < 100; i++)
            System.out.println();
    }
    // method to print a separator with length n
    public static void printSeparator(int n) {
        for (int i = 0; i < n; i++)
            System.out.println();
    }
    // method to print a heading
    public static void printHeading(String title) {
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }
    // method to stop the game until user enters anything
    public static void anythingToContinue() {
        System.out.println("\nEnter anything to continue...");
        scanner.next();
    }
    // Method to start game
    public static void startGame() {
        boolean nameSet;
        String name;
        // title screen
        clearConsole();
        printSeparator(40);
        printSeparator(30);
        System.out.println("The Elf Adventures");
        System.out.println("Text RPG");
        printSeparator(30);
        printSeparator(40);
        anythingToContinue();

        // getting players name do/while loop
        do {
            clearConsole();
            printHeading("What's your name?");
            name = scanner.next();
            // asking player to if they want to correct choice
            clearConsole();
            printHeading("Your name is " + name + ".\nIs that correct?");
            System.out.println("(1) Yes!");
            System.out.println("(2) No, I want a different name.");
            int input = readInt("-> ", 2);
            nameSet = true;
        }while(!nameSet);

        // print story intro
        Story.printIntro();

        // create new player object with the name
        player = new Player(name);

        // print first story intro
        Story.printFirstActIntro();


        // setting isRunning to true, so the game loop can continue
        isRunning = true;

        // start main game loop
        gameLoop();
    }
    // method to continue the Journey
    public static void continueJourney(){
    }
    //printing out the most important info about the player character
    public static void characterInfo() {
        clearConsole();
        printHeading("CHARACTER INFO");
        System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHp);
        System.out.println("XP: " + player.xp);
        printSeparator(20);

        // printing the chosen traits
        if(player.numAtkUpgrades > 0) {
            System.out.println("Offensive trait: " + player.atkUpgrades[player.numAtkUpgrades - 1]);
            printSeparator(20);
        }
        if(player.numDefUpgrades > 0) {
            System.out.println("Defensive trait: " + player.defUpgades[player.numDefUpgrades - 1]);
        }
        anythingToContinue();
    }

    // printing the main menu
    public static void printMenu(){
        clearConsole();
        printHeading(places[place]);
        System.out.println("Choose an action:");
        printSeparator(20);
        System.out.println("(1) Continue your journey.");
        System.out.println("(2) Character Info");
        System.out.println("(3) Exit Game");

    }

    // main game loop
    public static void gameLoop(){
        printMenu();
        int input = readInt("-> ", 3);
        if (input == 1)
            continueJourney();
        else if(input == 2)
            characterInfo();
        else isRunning = false;
    }
}
