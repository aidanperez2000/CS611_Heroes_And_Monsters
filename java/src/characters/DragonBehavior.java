package characters;

/*Class for determining behavior of dragon*/
public class DragonBehavior implements MonsterBehaviorStrategy {

    /*Dragons have higher damage so apply bonus damage to monster.
    * monster: monster to apply damage to*/
    @Override
    public void applyBonus(Monster monster) {
        monster.increaseDamage((int)(monster.getDamage() * 0.15));
    }
}
