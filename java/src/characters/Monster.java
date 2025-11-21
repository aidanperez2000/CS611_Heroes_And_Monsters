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

    /*Clone a monster for battle
    * returns: cloned monster*/
    public Monster cloneForBattle() {
        Monster monster = new Monster(this.name, this.monsterType, this.level, this.damage, this.defense,
                this.dodgeChance, this.monsterBehaviorStrategy);
        monster.setHp(this.hp);
        return monster;
    }

    /*Reduce defense by given percent
    * p: percent to reduce damage by*/
    public void reduceDefenseByPercent(double p) {
        defense = (int) Math.max(0, defense * (1 - p));
    }

    /*Reduce defense by given percent
    * p: percent to reduce defense by*/
    public void reduceDamageByPercent(double p) {
        damage = (int) Math.max(0, damage * (1 - p));
    }

    /*Reduce dodge chance by given percent
    * p: percent to reduce dodge chance by*/
    public void reduceDodgeChanceByPercent(double p) {
        dodgeChance = (int) Math.max(0, dodgeChance * (1 - p));
    }
}
