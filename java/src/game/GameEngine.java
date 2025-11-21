package game;

import characters.Hero;
import characters.Monster;
import characters.MonsterFactory;
import characters.Party;
import data.GameDatabase;
import helpers.IntHelpers;
import world.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*Class for running game logic*/
public class GameEngine {
    private final Party party;
    private final WorldMap map;
    private final Scanner scanner;
    private final MarketEngine marketEngine;
    private int heroRow, heroCol;
    private boolean running = true;

    //Command constants
    public static final String NORTH = "W";
    public static final String WEST = "A";
    public static final String SOUTH = "S";
    public static final String EAST = "D";
    public static final String INFO = "I";
    public static final String MARKET = "M";
    public static final String QUIT = "Q";

    public GameEngine() {
        // Load all game data ONCE when engine starts
        GameDatabase.LoadAll();
        party = new Party();
        map = new WorldMap(8, 8);
        scanner = new Scanner(System.in);
        marketEngine = new MarketEngine(scanner);
    }

    /*Run the game*/
    public void run() {
        System.out.println("Welcome to Monsters and Heroes!");
        chooseHeroes();
        int[] spawn = map.findSafeSpawn();
        heroRow = spawn[0];
        heroCol = spawn[1];
        System.out.println("\nYour adventure begins!");
        navigate();
    }

    private void navigate() {
        while (running) {
            map.printMap(heroRow, heroCol);
            printControls();
            System.out.print("\nEnter command: ");
            String command = scanner.nextLine().trim().toUpperCase();

            switch (command) {
                case NORTH: move(-1, 0); break;
                case WEST: move(0, -1); break;
                case SOUTH: move(1, 0); break;
                case EAST: move(0, 1); break;
                case INFO: party.showParty(); break;
                case MARKET:
                    Tile current = map.getTile(heroRow, heroCol);
                    if (current.getBehavior() instanceof MarketBehavior)
                        openMarket();
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
        System.out.println("How many heroes do you want to choose? (1-" + Party.MAX_PARTY_SIZE + ")");
        int count = 0;
        while (count < 1 || count > Party.MAX_PARTY_SIZE) {
            count = IntHelpers.getInt(scanner);
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
            int choice = IntHelpers.getInt(scanner) - 1;
            if (choice >= 0 && choice < allHeroes.size())
                party.addHero(allHeroes.get(choice));
            else
                System.out.println("Invalid hero!");
        }
    }

    /*Open the market*/
    public void openMarket() {
        marketEngine.open(party);
    }

    /*Start a new battle*/
    public void startBattle() {
        System.out.println("\nA wild group of monsters appears!");

        int maxHeroLevel = 1;
        for (Hero h: party.getHeroes())
            if (!h.isDead())
                maxHeroLevel = Math.max(maxHeroLevel, h.getLevel());

        //pick monsters for battle
        List<Monster> monsters = MonsterFactory.createMonstersForBattle(party, maxHeroLevel);

        BattleEngine battleEngine = new BattleEngine(party, monsters, scanner);
        boolean heroesWon = battleEngine.startBattle();

        if (!heroesWon) {
            System.out.println("Game over.");
            running = false;
        }
    }
}
