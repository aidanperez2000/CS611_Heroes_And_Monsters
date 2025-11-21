package characters;

/*Base character class which all characters inherit from*/
public abstract class Character {
    protected String name;
    protected int level;
    protected int hp;

    public Character(String name, int level, int hp) {
        this.name = name;
        this.level = level;
        this.hp = hp;
    }

    /*Get the name of the character
    * returns: name of character*/
    public String getName() {
        return name;
    }

    /*Get the level of the character
    * returns: level of character*/
    public int getLevel() {
        return level;
    }

    /*Get the hp of the character
    * returns: hp of character*/
    public int getHp() {
        return hp;
    }

    /*Set hp to a given value.
    * hp: hp to set*/
    public void setHp(int hp) {
        this.hp = hp;
    }

    /*Is this character dead?
    * returns: true if hp is less than or equal to 0 and false otherwise*/
    public boolean isDead() {
        return hp <= 0;
    }

    /*Decrease hp by amount damaged by
    * damage: amount to damage character*/
    public void takeDamage(int damage) {
        hp = Math.max(0, hp - damage);
    }
}
