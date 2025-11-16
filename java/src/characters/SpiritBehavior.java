package characters;

/*Class for determing behavior of spirit*/
public class SpiritBehavior implements MonsterBehaviorStrategy {

    /*Spirits have a higher dodge chance so apply bonus dodge chance to monster
     * monster: monster to apply bonus dodge chance to*/
    @Override
    public void applyBonus(Monster monster) {
        monster.increaseDodgeChance((int)(monster.getDodgeChance() * 0.15));
    }
}
