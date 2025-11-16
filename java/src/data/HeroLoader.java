package data;

import characters.*;

import java.util.ArrayList;
import java.util.List;

/*Class for loading heroes*/
public class HeroLoader implements DataLoader<Hero> {
    private final FileParser parser = new FileParser();
    /*Load any of the heroes files
    * resourcePath: path of file to load
    * returns: list of heroes parsed from file path*/
    @Override
    public List<Hero> load(String resourcePath) {
        List<List<String>> rows = parser.parse(resourcePath);
        List<Hero> heroes = new ArrayList<>();

        HeroClass type;
        LevelUpStrategy levelUpStrategy;
        if (resourcePath.contains("Warriors")) {
            type = HeroClass.WARRIOR;
            levelUpStrategy = new WarriorLevelUp();
        }
        else if (resourcePath.contains("Paladins")) {
            type = HeroClass.PALADIN;
            levelUpStrategy = new PaladinLevelUp();
        }
        else {
            type = HeroClass.SORCERER;
            levelUpStrategy = new SorcererLevelUp();
        }

        try {
            for (List<String> row : rows) {
                heroes.add(new Hero(
                        row.get(0),
                        type,
                        Integer.parseInt(row.get(1)),  // mana
                        Integer.parseInt(row.get(2)),  // strength
                        Integer.parseInt(row.get(3)),  // agility
                        Integer.parseInt(row.get(4)),  // dexterity
                        Integer.parseInt(row.get(5)),  // starting gold
                        Integer.parseInt(row.get(6)),  // starting exp
                        levelUpStrategy
                ));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return heroes;
    }
}
