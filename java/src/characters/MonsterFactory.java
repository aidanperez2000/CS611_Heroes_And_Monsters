package characters;

import data.GameDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*Factory class for creating monsters for battles*/
public class MonsterFactory {
    private static final Random rand = new Random();

    /*Create monsters scaled to the party
     * party: party of heroes
     * targetLevel: level of monsters (usually max hero level)
     * returns: list of monsters*/
    public static List<Monster> createMonstersForBattle(Party party, int targetLevel) {
        int count = party.getHeroes().size();
        List<Monster> monsters = new ArrayList<>();

        List<Monster> allMonsters = new ArrayList<>();
        allMonsters.addAll(GameDatabase.dragons);
        allMonsters.addAll(GameDatabase.exoskeletons);
        allMonsters.addAll(GameDatabase.spirits);
        for (int i = 0; i < count; i++)
            monsters.add(pickMonsterForLevel(allMonsters, targetLevel));

        return monsters;
    }

    /*Pick a monster whose level is close to the target level
    * all: all monsters to choose from
    * targetLevel: level which we want monster to be near
    * returns: monster selected*/
    private static Monster pickMonsterForLevel(List<Monster> all, int targetLevel) {
        List<Monster> candidates = new ArrayList<>();

        for (Monster monster : all)
            if (monster.getLevel() == targetLevel)
                candidates.add(monster);

        if (candidates.isEmpty())
            candidates.addAll(all);

        Monster template = candidates.get(rand.nextInt(candidates.size()));
        /*make a clone so we don't accidentally modify txt files*/
        return template.cloneForBattle();
    }
}
