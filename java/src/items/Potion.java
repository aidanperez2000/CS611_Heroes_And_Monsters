package items;

import java.util.List;

/*Class for keeping track of potion information*/
public class Potion extends Item {
    private final int effectAmount;
    private final List<StatType> affectedStats;
    public Potion(String name, int price, int requiredLevel,
                  int effectAmount, List<StatType> affectedStats) {
        super(name, price, requiredLevel);
        this.effectAmount = effectAmount;
        this.affectedStats = affectedStats;
    }

    /*Get the effect amount of a potion
    * returns: effect amount of potion*/
    public int getEffectAmount() {
        return effectAmount;
    }

    /*Get affected stats of potion
    * returns: affected stats of potion*/
    public List<StatType> getAffectedStats() {
        return affectedStats;
    }
}
