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
}
