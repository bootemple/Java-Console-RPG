package TextRPG;

// class that does nothing but stores methods to print out every part of the story
public class Story {

    public static void printIntro(){
GameLogic.clearConsole();
GameLogic.printSeparator(30);
System.out.println("STORY");
GameLogic.printSeparator(30);
System.out.println("You are the last of the elves.");
        System.out.println("Journey to the center of the ancient woods to find the spirits of your ancestors.");
        System.out.println("Once you have acquired the holy staff, you may revive you family.");
        GameLogic.anythingToContinue();
    }

    public static void printFirstActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("STORY");
        GameLogic.printSeparator(30);
        System.out.println("You are the last of the elves.");
        System.out.println("Journey to the center of the ancient woods to find the spirits of your ancestors.");
        System.out.println("Once you have acquired the holy staff, you may revive you family.");
        GameLogic.anythingToContinue();
    }

    public static void printSecondActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("STORY");
        GameLogic.printSeparator(30);
        System.out.println("You are the last of the elves.");
        System.out.println("Journey to the center of the ancient woods to find the spirits of your ancestors.");
        System.out.println("Once you have acquired the holy staff, you may revive you family.");
        GameLogic.anythingToContinue();
    }
}
