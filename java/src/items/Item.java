package items;

/*Abstract class which all other item classes inherit from*/
public abstract class Item {
    protected String name;
    protected int price;
    protected int requiredLevel;

    public Item(String name, int price, int requiredLevel) {
        this.name = name;
        this.price = price;
        this.requiredLevel = requiredLevel;
    }

    /*Get the name of the item
    * returns: name of item*/
    public String getName() {
        return name;
    }

    /*Get the price of the item:
    * returns: price of item*/
    public int getPrice() {
        return price;
    }

    /*Get the required level of the item
    * returns: required level of item*/
    public int getRequiredLevel() {
        return requiredLevel;
    }

    /*Check to see if this item can be used by a given level
    * level: level to check
    * returns: true if level is greater than equal to required level and
    * false otherwise*/
    public boolean canBeUsedBy(int level) {
        return level >= requiredLevel;
    }
}
