package data;

import items.Spell;
import items.SpellType;

import java.util.ArrayList;
import java.util.List;

/*Class for loading spells*/
public class SpellLoader implements DataLoader<Spell> {
    private final FileParser parser = new FileParser();

    /*Load any of the spells files
     * resourcePath: path of file to load
     * returns: list of spells parsed from file path*/
    @Override
    public List<Spell> load(String resourcePath) {
        List<List<String>> rows = parser.parse(resourcePath);
        List<Spell> spells = new ArrayList<>();

        SpellType type;

        if (resourcePath.contains("Fire"))
            type = SpellType.FIRE;
        else if (resourcePath.contains("Ice"))
            type = SpellType.ICE;
        else
            type = SpellType.LIGHTNING;

        for (List<String> row : rows) {
            spells.add(new Spell(
                    row.get(0),
                    Integer.parseInt(row.get(1)),
                    Integer.parseInt(row.get(2)),
                    type,
                    Integer.parseInt(row.get(3)),
                    Integer.parseInt(row.get(4))
            ));
        }

        return spells;
    }
}
