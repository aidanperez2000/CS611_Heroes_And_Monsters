package data;

import items.Armor;

import java.util.ArrayList;
import java.util.List;

/*Class for loading armors*/
public class ArmorLoader implements DataLoader<Armor> {
    private final FileParser parser = new FileParser();

    /*Load the armor file
     * resourcePath: path of file to load
     * returns: list of armors parsed from file path*/
    @Override
    public List<Armor> load(String resourcePath) {
        List<List<String>> rows = parser.parse(resourcePath);
        List<Armor> armor = new ArrayList<>();

        for (List<String> row : rows) {
            armor.add(new Armor(
                    row.get(0),
                    Integer.parseInt(row.get(1)),  // cost
                    Integer.parseInt(row.get(2)),  // level
                    Integer.parseInt(row.get(3))   // damage reduction
            ));
        }

        return armor;
    }
}
