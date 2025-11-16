package game;

import characters.Hero;
import characters.Party;
import data.GameDatabase;
import world.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameEngine {
    private final Party party;
    private WorldMap map;
    private int heroRow = 0, heroCol = 0;

    public GameEngine() {
        // Load all game data ONCE when engine starts
        GameDatabase.LoadAll();
        party = new Party();
        generateMap();
    }

    public void run() {
        System.out.println("Welcome to Monsters and Heroes!");
        chooseHeroes();
        party.showParty();
        map.printMap(heroRow, heroCol);
    }

    public void chooseHeroes() {
        System.out.println("Choose your 3 heroes!");

        // Combine all heroes into one list
        List<Hero> allHeroes = new ArrayList<>();
        allHeroes.addAll(GameDatabase.warriors);
        allHeroes.addAll(GameDatabase.paladins);
        allHeroes.addAll(GameDatabase.sorcerers);

        // Display them
        for (int i = 0; i < allHeroes.size(); i++) {
            System.out.println((i + 1) + ": " + allHeroes.get(i).getName());
        }

        Scanner input = new Scanner(System.in);
        while (party.getHeroCount() < Party.MAX_PARTY_SIZE) {
            System.out.println("Choose a hero!");

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

    public void openMarket() {
        //TODO: implement this method
    }

    public void startBattle() {
        //TODO: implement this method
        System.out.println("Starting Battle!");
    }

    private void generateMap() {
        map = new WorldMap(8, 8);

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                double roll = Math.random();

                if (roll < 0.2)
                    map.setTile(x, y, new Tile(new InaccesibleBehavior()));
                else if (roll < 0.5)
                    map.setTile(x, y, new Tile(new MarketBehavior()));
                else
                    map.setTile(x, y, new Tile(new CommonBehavior()));
            }
        }
    }
}
