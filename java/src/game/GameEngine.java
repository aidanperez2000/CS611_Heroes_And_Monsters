package game;

import characters.Hero;
import data.GameDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameEngine {
    public GameEngine() {
        // Load all game data ONCE when engine starts
        GameDatabase.LoadAll();
    }

    public void run() {
        System.out.println("Welcome to Monsters and Heroes!");
        chooseHeroes();
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
    }
}
