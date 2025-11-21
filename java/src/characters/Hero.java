package characters;

import items.*;

/*Class for keeping track of heroes.  Heroes include
* paladins, sorcerers, and warriors*/
public class Hero extends Character {
    private int mana;
    private int strength;
    private int agility;
    private int dexterity;
    private int gold;
    private int experience;

    private final HeroClass heroClass;
    private final LevelUpStrategy levelUpStrategy;

    private Inventory inventory;
    private Weapon equippedWeapon;
    private Armor equippedArmor;

    public Hero(String name, HeroClass heroClass,
                int mana, int strength, int agility, int dexterity,
                int gold, int experience, LevelUpStrategy strategy) {
        super(name, 1, 100);
        this.heroClass = heroClass;
        this.mana = mana;
        this.strength = strength;
        this.agility = agility;
        this.dexterity = dexterity;
        this.gold = gold;
        this.experience = experience;
        this.levelUpStrategy = strategy;

        this.inventory = new Inventory();
    }

    /*Increase experience for a user by a certain amount.  Level up
    * if necessary.
    * amount: amount to increase experience for user*/
    public void gainExperience(int amount) {
        experience += amount;

        /*if our experience is more 10 times our level, we'll want
        * to reset our experience and level up*/
        if (experience >= level * 10) {
            experience -= level * 10;
            level++;
            levelUpStrategy.applyLevelUp(this);
        }
    }

    /*Get mana of hero
    * returns: mana of hero*/
    public int getMana() {
        return mana;
    }

    /*Get strength of hero
    * returns: strength of hero*/
    public int getStrength() {
        return strength;
    }

    /*Get agility of hero
    * returns: agility of hero*/
    public int getAgility() {
        return agility;
    }

    /*Get dexterity of hero
    * returns: dexterity of hero*/
    public int getDexterity() {
        return dexterity;
    }

    /*Get gold of hero
    * returns: gold of hero*/
    public int getGold() {
        return gold;
    }

    /*Increase hp by a given amount
    * amount: amount to increase hp by*/
    public void increaseHp(int amount) {
        this.hp += amount;
    }

    /*Increase mana by a given amount
    * amount: amount to increase mana by*/
    public void increaseMana(int amount) {
        this.mana += amount;
    }

    /*Increase strength by a given amount
    * amount: amount to increase strength by*/
    public void increaseStrength(int amount) {
        this.strength += amount;
    }

    /*Increase agility by a given amount
    * amount: amount to increase agility by*/
    public void increaseAgility(int amount) {
        this.agility += amount;
    }

    /*Increase dexterity by a given amount
    * amount: amount to increase dexterity by*/
    public void increaseDexterity(int amount) {
        this.dexterity += amount;
    }

    /*Increase gold by a given amount
    * amount: amount to increase gold by*/
    public void increaseGold(int amount) {
        this.gold += amount;
    }

    /*Decrease gold by a given amount
    * amount: amount to decrease gold by
    * returns: true if amount could be spent and false otherwise*/
    public boolean spendGold(int amount) {
        if (gold >= amount) {
            gold -= amount;
            return true;
        }
        return false;
    }

    /*Get the hero's inventory
    * returns: hero's inventory*/
    public Inventory getInventory() {
        return inventory;
    }

    /*Get the type of hero
    * returns: hero class which is enum that determines type of hero*/
    public HeroClass getHeroClass() {
        return heroClass;
    }

    /*Reduce mana by a certain amount*/
    public void spendMana(int amount) {
        mana = Math.max(mana - amount, 0);
    }

    /*Kill a hero by setting hp to 0*/
    public void kill() {
        hp = 0;
    }

    /*Revive hero's mana and hp by half*/
    public void reviveAtHalf() {
        hp = (level * 100) / 2;
        mana = mana / 2;
    }

    /*Get equipped weapon of hero
    * returns: hero's equipped weapon*/
    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    /*Set equipped weapon for hero
    * weapon: weapon to set*/
    public void equipWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
    }

    /*Get equipped armor
    * returns: equipped armor of hero*/
    public Armor getEquippedArmor() {
        return equippedArmor;
    }

    /*Set equipped armor for hero
    * armor: armor to set*/
    public void equipArmor(Armor armor) {
        this.equippedArmor = armor;
    }

    /*Increase hp and mana, to be used at the end of a
    * battle if hero wins*/
    public void regenEndOfRound() {
        hp = Math.min(level * 100, hp + (int) (0.1 * hp));
        mana = Math.min(mana + (int) (0.1 * mana), mana + 10);
    }

    public void applyPotion(Potion potion) {
        for (StatType statType : potion.getAffectedStats()) {
            switch (statType) {
                case HEALTH: increaseHp(potion.getEffectAmount()); break;
                case MANA: increaseMana(potion.getEffectAmount()); break;
                case STRENGTH: increaseStrength(potion.getEffectAmount()); break;
                case DEXTERITY: increaseDexterity(potion.getEffectAmount()); break;
                case AGILITY: increaseAgility(potion.getEffectAmount()); break;
            }
        }
    }
}
