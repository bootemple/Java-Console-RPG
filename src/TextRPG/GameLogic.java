package TextRPG;

import java.util.Scanner;

public class GameLogic {
    // scan for user input
    static Scanner scanner = new Scanner(System.in);

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
}
