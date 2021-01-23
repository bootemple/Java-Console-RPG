package TextRPG;

public class Player extends Character{
    // integers to store number of upgrades/skills in each path
    public int numAtkUpgrades, numDefUpgrades;

    // Arrays to store skill names
    // Offensive Skills
    public String[] atkUpgrades = {"Strength", "Power", "Might", "Ultimate"};
    // Defensive Skills
    public String[] defUpgades = {"Hide Armor", "Bronze Armor", "Iron Armor", "Dragon Scales"};

    // Player specific constructor
    public Player(String name) {
        // Calling constructor of superclass
        super(name, 100, 0);
        // Setting # of upgrades to 0
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;
        // let player choose a trait when creating newe character
        chooseTrait();
    }
    // Player specific methods
    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int defend() {
        return 0;
    }
    // let player choose a trait of either skill path
    public void chooseTrait() {
        GameLogic.clearConsole();
        GameLogic.printHeading("Chose a trait.");
        System.out.println("(1) " + atkUpgrades[numAtkUpgrades]);
        System.out.println("(2) " + defUpgades[numDefUpgrades]);
        // get the players choice:
        int input = GameLogic.readInt("-> ", 2);
        GameLogic.clearConsole();
        // if else statement for players choice, leveling up attack or defense
        if(input == 1) {
            GameLogic.printHeading("You chose " + atkUpgrades[numAtkUpgrades] + "!");
            numAtkUpgrades++;
        } else {
            GameLogic.printHeading("You chose " + defUpgades[numDefUpgrades] + "!");
            numDefUpgrades++;
        }
        GameLogic.anythingToContinue();
    }
    // Method to start game
    public static void startGame() {

    }
}
