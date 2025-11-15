package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileParser {
    public static List<String[]> parseFile(String filePath) throws IOException {
        List<String[]> rows = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty())
                    continue;

                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] row = line.split("\\s+");
                rows.add(row);
            }
        }
        catch (Exception e) {
            System.err.println("Error while parsing file " + filePath);
            System.err.println(e.getMessage());
        }
        return rows;
    }
}
