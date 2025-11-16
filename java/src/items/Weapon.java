package items;

/*Class for keeping track of weapons*/
public class Weapon extends Item {
    private final int damage;
    private final int handsRequired;

    public Weapon(String name, int price, int requiredLevel,
                  int damage, int handsRequired) {
        super(name, price, requiredLevel);
        this.damage = damage;
        this.handsRequired = handsRequired;
    }

    /*Get damage of weapon
    * returns: damage of weapon*/
    public int getDamage() {
        return damage;
    }

    /*Get number of hands required for weapon
    * returns: number of hands required for Weapon*/
    public int getHandsRequired() {
        return handsRequired;
    }
}
