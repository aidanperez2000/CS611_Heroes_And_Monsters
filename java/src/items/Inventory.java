package items;

import java.util.ArrayList;
import java.util.List;

/*Class for keeping track of inventory*/
public class Inventory {
    private final List<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    /*Add an item to a list of items
    * item: item to add*/
    public void addItem(Item item) {
        items.add(item);
    }

    /*Remove an item from a list of items
    * item: item to remove*/
    public void removeItem(Item item) {
        items.remove(item);
    }

    /*Get the list of items in an inventory
    * returns: list of items in inventory*/
    public List<Item> getItems() {
        return items;
    }

    /*Get weapons in inventory*/
    public List<Weapon> getWeapons() {
        List<Weapon> weapons = new ArrayList<>();
        for (Item item : items)
            if (item instanceof Weapon)
                weapons.add((Weapon) item);
        return weapons;
    }

    /*Get armors in inventory*/
    public List<Armor> getArmors() {
        List<Armor> armors = new ArrayList<>();
        for (Item item : items)
            if (item instanceof Armor)
                armors.add((Armor) item);
        return armors;
    }

    /*Get potions in inventory*/
    public List<Potion> getPotions() {
        List<Potion> potions = new ArrayList<>();
        for (Item item : items)
            if (item instanceof Potion)
                potions.add((Potion) item);
        return potions;
    }

    /*Get spells in inventory*/
    public List<Spell> getSpells() {
        List<Spell> spells = new ArrayList<>();
        for (Item item : items)
            if (item instanceof Spell)
                spells.add((Spell) item);
        return spells;
    }

    /*Remove a potion from the list of items*/
    public void removePotion(Potion potion) {
        items.remove(potion);
    }

    /*Remove a spell from the list of items*/
    public void removeSpell(Spell spell) {
        items.remove(spell);
    }
}
