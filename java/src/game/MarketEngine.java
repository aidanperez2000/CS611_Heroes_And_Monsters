package game;

import characters.Hero;
import characters.Party;
import data.GameDatabase;
import helpers.IntHelpers;
import items.Item;

import java.util.List;
import java.util.Scanner;

/*Class for handling market logic*/
public class MarketEngine {
    private final Scanner scanner;

    public MarketEngine(Scanner scanner) {
        this.scanner = scanner;
    }

    /*Open the market.  User can buy or sell items.
    * party: party with heroes to choose from*/
    public void open(Party party) {
        boolean running = true;
        while (running) {
            System.out.println("\n=== MARKET ===");
            System.out.println("1) Buy");
            System.out.println("2) Sell");
            System.out.println("3) Hero Info");
            System.out.println("4) Exit Market");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1": buyMenu(party); break;
                case "2": sellMenu(party); break;
                case "3": party.showParty(); break;
                case "4": running = false; break;
                default: System.out.println("Invalid choice"); break;
            }
        }
    }

    /*View menu of items to buy and select item to buy
    * party: party with heroes to choose from*/
    private void buyMenu(Party party) {
        Hero hero = chooseHero(party);
        if (hero == null)
            return;

        System.out.println("\nWhat would you like to buy?");
        System.out.println("1) Weapons");
        System.out.println("2) Armor");
        System.out.println("3) Potions");
        System.out.println("4) Spells");
        System.out.println("5) Back");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1": buyItem(hero, GameDatabase.weapons); break;
            case "2": buyItem(hero, GameDatabase.armor); break;
            case "3": buyItem(hero, GameDatabase.potions); break;
            case "4":
                System.out.println("Choose spell type:");
                System.out.println("1) Fire Spells");
                System.out.println("2) Ice Spells");
                System.out.println("3) Lightning Spells");

                String s = scanner.nextLine().trim();

                switch (s) {
                    case "1": buyItem(hero, GameDatabase.fireSpells); break;
                    case "2": buyItem(hero, GameDatabase.iceSpells); break;
                    case "3": buyItem(hero, GameDatabase.lightningSpells); break;
                }
                break;
        }
    }

    /*Buy an item.  If the hero has enough gold and is a high enough level,
    * item will be added to hero's inventory and hero's gold will be reduced
    * by item price
    * hero: hero to buy item
    * items: list of items to buy, the class can be any class that extends items*/
    private <T extends Item> void buyItem(Hero hero, List<T> items) {
        System.out.println("=== ITEMS FOR SALE ===");
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            System.out.println("Item " + (i + 1) + ": " + item.getName()
                    + " | Price: " + item.getPrice() +
                    " | Required Level: " + item.getRequiredLevel());
        }
        System.out.println("Choose item number or 0 to cancel");

        int idx = IntHelpers.getInt(scanner) - 1;
        if (idx < 0 || idx >= items.size())
            return;

        Item item = items.get(idx);
        //heroes cannot buy an item if their level is too low
        if (hero.getLevel() < item.getRequiredLevel()) {
            System.out.println("Hero's level is too low!");
            return;
        }

        //heroes cannot buy items more expensive than their total gold
        if (!hero.spendGold(item.getPrice())) {
            System.out.println("Hero's gold is too low!");
            return;
        }
        hero.getInventory().addItem(item);

        System.out.println(hero.getName() + " bought " + item.getName() + " for " + item.getPrice() + "!");
    }

    /*View menu of items to sell.  Hero sells item for half its original price
    * party: party with heroes to buy from*/
    private void sellMenu(Party party) {
        Hero hero = chooseHero(party);

        if (hero == null)
            return;

        List<Item> items = hero.getInventory().getItems();

        if (items.isEmpty()) {
            System.out.println("There are no items in your inventory!");
            return;
        }

        System.out.println("Choose item number or 0 to cancel");

        System.out.println("\n===ITEMS FOR SALE ===");
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            System.out.println((i + 1) + ") " + item.getName() + " (Sell Price: " +
                    (item.getPrice() / 2) + ")");
        }

        int idx = IntHelpers.getInt(scanner) - 1;
        if (idx < 0 || idx >= items.size())
            return;

        Item item = items.get(idx);
        /*All the prices are even numbers so dividing by two will always give whole numbers.
        * If I have time, I'll come back and refactor this so that if we have any pricees with odd numbers.
        * The gold increase by actually half.*/
        hero.increaseGold(item.getPrice() / 2);
        hero.getInventory().removeItem(item);

        System.out.println("Sold " + item.getName() + " for " + (item.getPrice() / 2) + "!");
    }

    /*Choose the hero to buy or sell an item
    * party: party with heroes to choose from
    * returns: hero chosen*/
    private Hero chooseHero(Party party) {
        List<Hero> heroes = party.getHeroes();

        if (heroes.isEmpty()) {
            System.out.println("There are no heroes for this party.");
            return null;
        }

        System.out.println("Choose hero:");

        for (int i = 0; i < heroes.size(); i++)
            System.out.println((i + 1) + ") " + heroes.get(i).getName());

        int choice = IntHelpers.getInt(scanner) - 1;
        if (choice < 0 || choice >= heroes.size())
            return null;
        return heroes.get(choice);
    }
}
