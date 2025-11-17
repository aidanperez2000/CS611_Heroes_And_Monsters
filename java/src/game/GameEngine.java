package game;

import characters.Hero;
import characters.Party;
import characters.SorcererLevelUp;
import data.GameDatabase;
import world.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*Class for running game logic*/
public class GameEngine {
    private final Party party;
    private WorldMap map;
    private int heroRow = 0, heroCol = 0;
    private boolean running = false;

    //Command constants
    private final String NORTH = "W";
    private final String WEST = "A";
    private final String SOUTH = "S";
    private final String EAST = "D";
    private final String INFO = "I";
    private final String MARKET = "M";
    private final String QUIT = "Q";

    public GameEngine() {
        // Load all game data ONCE when engine starts
        GameDatabase.LoadAll();
        party = new Party();
        map = new WorldMap(8, 8);
    }

    /*Run the game*/
    public void run() {
        System.out.println("Welcome to Monsters and Heroes!");
        chooseHeroes();
        System.out.println("\nYour adventure begins!");
        navigate();
    }

    private void navigate() {
        Scanner in = new Scanner(System.in);

        while (running) {
            map.printMap(heroRow, heroCol);
            printControls();
            System.out.print("\nEnter command: ");
            String command = in.nextLine().trim().toUpperCase();

            switch (command) {
                case NORTH: move(-1, 0); break;
                case WEST: move(0, -1); break;
                case SOUTH: move(1, 0); break;
                case EAST: move(0, 1); break;
                case INFO: party.showParty(); break;
                case MARKET:
                    Tile current = map.getTile(heroRow, heroCol);
                    if (current.getBehavior() instanceof MarketBehavior)
                        enterMarket();
                    else
                        System.out.println("You are not in a market!");
                    break;
                case QUIT:
                    running = false;
                    System.out.println("Goodbye, hero!");
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        }
    }

    /*Print the controls for the game*/
    private void printControls() {
        System.out.println("\nControls:");
        System.out.println(NORTH + "/" + WEST + "/" + SOUTH + "/" + EAST + "("
                + NORTH.toLowerCase() + "/" + WEST.toLowerCase() + "/" + SOUTH.toLowerCase() +
                "/" + EAST.toLowerCase() + ") - Move");
        System.out.println(MARKET + "(" + MARKET.toLowerCase() + ") - Market");
        System.out.println(INFO + "(" + INFO.toLowerCase() + ") - Info");
        System.out.println(QUIT + "(" + QUIT.toLowerCase() + ") - Quit");
    }

    /*Move a player to a new row or column
    * row: row change
    * col: column change*/
    private void move(int row, int col) {
        int newRow = heroRow + row;
        int newCol = heroCol + col;

        if (newRow < 0 || newCol < 0 ||
                newRow >= map.getRows() || newCol >= map.getCols()) {
            System.out.println("Invalid row or column!");
            return;
        }

        Tile tile = map.getTile(newRow, newCol);

        if (!tile.isAccessible()) {
            System.out.println("Tile is not accessible!");
            return;
        }

        heroRow = newRow;
        heroCol = newCol;

        tile.enter(this);
    }

    /*Choose heroes for the game*/
    public void chooseHeroes() {
        Scanner input = new Scanner(System.in);
        System.out.println("How many heroes you want to choose? (1-" + Party.MAX_PARTY_SIZE + ")");
        int count = 0;
        while (count < 1 || count > Party.MAX_PARTY_SIZE) {
            try {
                count = Integer.parseInt(input.nextLine().trim());
            }
            catch (NumberFormatException e) {
                System.out.println("Please enter a number between 1 and " + Party.MAX_PARTY_SIZE);
            }
            if (count < 1 || count > Party.MAX_PARTY_SIZE) {
                System.out.println("Please enter a number between 1 and " + Party.MAX_PARTY_SIZE);
            }
        }
        List<Hero> allHeroes = new ArrayList<>();
        allHeroes.addAll(GameDatabase.paladins);
        allHeroes.addAll(GameDatabase.sorcerers);
        allHeroes.addAll(GameDatabase.warriors);

        // Display heroes
        for (int i = 0; i < allHeroes.size(); i++)
            System.out.println((i + 1) + ": " + allHeroes.get(i).getName());

        while (party.getHeroCount() < count) {
            System.out.println("Choose hero #" + (party.getHeroCount() + 1) + ": ");

            try {
                int choice = Integer.parseInt(input.nextLine()) - 1;
                if (choice >= 0 && choice < allHeroes.size()) {
                    party.addHero(allHeroes.get(choice));
                }
                else {
                    System.out.println("Invalid hero!");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
    }

    public void enterMarket() {
        System.out.println("Entering the market");
        //TODO: implement this method
    }

    public void openMarket() {
        //TODO: implement this method
    }

    public void startBattle() {
        //TODO: implement this method
        System.out.println("Starting Battle!");
    }
}
