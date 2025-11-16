package data;

import items.Weapon;

import java.util.ArrayList;
import java.util.List;

/*Class for loading weapons*/
public class WeaponLoader implements DataLoader<Weapon> {
    private final FileParser parser = new FileParser();

    /*Load the weapons file
     * resourcePath: path of file to load
     * returns: list of weapons parsed from file path*/
    @Override
    public List<Weapon> load(String resourcePath) {
        List<List<String>> rows = parser.parse(resourcePath);
        List<Weapon> weapons = new ArrayList<>();

        try {
            for (List<String> row : rows) {
                weapons.add(new Weapon(
                        row.get(0),
                        Integer.parseInt(row.get(1)),  // cost
                        Integer.parseInt(row.get(2)),  // level
                        Integer.parseInt(row.get(3)),  // damage
                        Integer.parseInt(row.get(4))   // hands
                ));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return weapons;
    }
}
