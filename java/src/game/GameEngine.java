package game;

import characters.Hero;
import characters.Party;
import data.GameDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameEngine {
    private Party party;

    public GameEngine() {
        // Load all game data ONCE when engine starts
        GameDatabase.LoadAll();
        party = new Party();
    }

    public void run() {
        System.out.println("Welcome to Monsters and Heroes!");
        chooseHeroes();
        party.showParty();
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
}
