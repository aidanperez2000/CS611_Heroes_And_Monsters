package data;

import items.Potion;
import items.StatType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Class for loading potions*/
public class PotionLoader implements DataLoader<Potion>{
    private final FileParser parser = new FileParser();

    /*Load the potions file
     * resourcePath: path of file to load
     * returns: list of potions parsed from file path*/
    @Override
    public List<Potion> load(String resourcePath) {
        List<List<String>> rows = parser.parse(resourcePath);
        List<Potion> potions = new ArrayList<>();

        for (List<String> row : rows) {

            String name = row.get(0);
            int cost = Integer.parseInt(row.get(1));
            int level = Integer.parseInt(row.get(2));
            int amount = Integer.parseInt(row.get(3));

            String attrField = row.get(4);

            List<StatType> stats = parseStatTypes(attrField);

            potions.add(new Potion(name, cost, level, amount, stats));
        }

        return potions;
    }

    /*Parse the affected stats from the file as a list of stat types
    * raw: stat types from file
    * returns: stat types as list of stat types*/
    private List<StatType> parseStatTypes(String raw) {
        List<StatType> stats = new ArrayList<>();

        // Example: "All Health/Mana/Strength"
        raw = raw.trim();

        // Remove "All " if present
        if (raw.toUpperCase().startsWith("ALL")) {
            raw = raw.substring(3).trim();  // remove the "All"
        }

        // Split by slash or comma
        String[] parts = raw.split("[/,]");

        try {
            for (String part : parts) {
                String cleaned = part.trim().toUpperCase();

                if (cleaned.isEmpty()) continue;

                try {
                    stats.add(StatType.valueOf(cleaned));
                } catch (IllegalArgumentException ex) {
                    System.err.println("WARNING: Unknown stat type '" + cleaned + "'");
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return stats;
    }
}
