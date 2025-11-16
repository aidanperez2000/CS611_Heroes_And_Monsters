package characters;

/*Class for keeping track of monster information*/
public class Monster extends Character {
    private int damage;
    private int defense;
    private int dodgeChance;

    private final MonsterType monsterType;
    private MonsterBehaviorStrategy monsterBehaviorStrategy;

    public Monster(String name, MonsterType monsterType,
                   int level, int damage, int defense, int dodgeChance,
                   MonsterBehaviorStrategy monsterBehaviorStrategy) {
        super(name, level, level * 100);
        this.monsterType = monsterType;
        this.damage = damage;
        this.defense = defense;
        this.dodgeChance = dodgeChance;
        this.monsterBehaviorStrategy = monsterBehaviorStrategy;

        monsterBehaviorStrategy.applyBonus(this);
    }

    /*Get damage of monster
    * returns: damage of monster*/
    public int getDamage() {
        return damage;
    }

    /*Get defense of monster
    * returns: defense of monster*/
    public int getDefense() {
        return defense;
    }

    /*Get chance that monster will dodge
    * returns: monster dodge chance*/
    public int getDodgeChance() {
        return dodgeChance;
    }

    /*Increase damage of monster
    * amount: amount to increase damage by*/
    public void increaseDamage(int amount) {
        damage += amount;
    }

    /*Increase defense of monster
    * amount: amount to increase defense by*/
    public void increaseDefense(int amount) {
        defense += amount;
    }

    /*Increase dodge chance of monster
    * amount: amount increase dodge chance by*/
    public void increaseDodgeChance(int amount) {
        dodgeChance += amount;
    }

    /*Get type of monster
    * returns: monster type which is enum that determines
    * type of monster*/
    public MonsterType getMonsterType() {
        return monsterType;
    }
}
