package TextRPG;

import java.util.Scanner;

public class GameLogic {
    // scan for user input
    static Scanner scanner = new Scanner(System.in);

    static Player player;
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

        // create new player object with the name
        player = new Player(name);

        // start main game loop
        // gameLoop();
    }
}
