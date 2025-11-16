package data;

import characters.*;

import java.util.ArrayList;
import java.util.List;

/*Class for loading monsters*/
public class MonsterLoader implements DataLoader<Monster> {
    private final FileParser parser = new FileParser();

    /*Load any of the monsters files
     * resourcePath: path of file to load
     * returns: list of monsters parsed from file path*/
    @Override
    public List<Monster> load(String resourcePath) {
        List<List<String>> rows = parser.parse(resourcePath);
        List<Monster> monsters = new ArrayList<>();

        MonsterType type;
        MonsterBehaviorStrategy behavior;
        if (resourcePath.contains("Dragons")) {
            type = MonsterType.DRAGON;
            behavior = new DragonBehavior();
        }
        else if (resourcePath.contains("Exoskeletons")) {
            type = MonsterType.EXOSKELETON;
            behavior = new ExoskeletonBehavior();
        }
        else {
            type = MonsterType.SPIRIT;
            behavior = new SpiritBehavior();
        }

        for (List<String> row : rows) {
            monsters.add(new Monster(
                    row.get(0),                     // name
                    type,                           // monster type
                    Integer.parseInt(row.get(1)),   // level
                    Integer.parseInt(row.get(2)),   // damage
                    Integer.parseInt(row.get(3)),   // defense
                    Integer.parseInt(row.get(4)),   // dodge
                    behavior                        // behavior
            ));
        }

        return monsters;
    }
}
