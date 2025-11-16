package characters;

/*Base class for determining monster behavior*/
public interface MonsterBehaviorStrategy {
    /*Apply of an attribute to a monster
    * monster: monster to apply bonus attribute to*/
    void applyBonus(Monster monster);
}
