package characters;

/*Class for determining behavior of exoskeleton*/
public class ExoskeletonBehavior implements MonsterBehaviorStrategy {

    /*Exoskeletons have a higher defense so apply bonus defense to monster
    * monster: monster to apply bonus defense to*/
    @Override
    public void applyBonus(Monster monster) {
        monster.increaseDefense((int)(monster.getDefense() * 0.15));
    }
}
