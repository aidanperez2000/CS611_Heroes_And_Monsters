package items;

/*Class for keeping track of spell information*/
public class Spell extends Item {
    private final SpellType spellType;
    private final int damage;
    private final int manaCost;

    public Spell(String name, int price, int requiredLevel,
                 SpellType spellType, int damage, int manaCost) {
        super(name, price, requiredLevel);
        this.spellType = spellType;
        this.damage = damage;
        this.manaCost = manaCost;
    }

    /*Get the type of the spell
    * returns: type of spell, which is enum*/
    public SpellType getSpellType() {
        return spellType;
    }

    /*Get damage of spell
    * returns: damage of spell*/
    public int getDamage() {
        return damage;
    }

    /*Get mana cost of spell
    * returns: mana cost of spell*/
    public int getManaCost() {
        return manaCost;
    }
}
