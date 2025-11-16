package items;

/*class for keeping track of armor*/
public class Armor extends Item {
    private final int damageReduction;

    public Armor(String name, int price, int requiredLevel, int damageReduction) {
        super(name, price, requiredLevel);
        this.damageReduction = damageReduction;
    }

    /*Get the damage reduction of the armor
    * returns: damage reduction of armor*/
    public int getDamageReduction() {
        return damageReduction;
    }
}
