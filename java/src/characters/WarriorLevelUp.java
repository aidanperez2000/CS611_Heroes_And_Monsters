package characters;

/*Strategy for leveling up for a warrior*/
public class WarriorLevelUp implements LevelUpStrategy {

    /*Increase attributes of a warrior when they level up
    * hero: hero to level up*/
    @Override
    public void applyLevelUp(Hero hero) {
        hero.increaseHp(100);
        hero.increaseStrength((int) (hero.getStrength() * 0.10));
        hero.increaseAgility((int) (hero.getAgility() * 0.10));
        hero.increaseDexterity((int) (hero.getDexterity() * 0.05));
        hero.increaseMana(10);
    }
}
