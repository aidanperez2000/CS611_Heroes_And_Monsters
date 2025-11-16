package data;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Helper class for parsing files*/
public class FileParser {

    /*Parse file at a given path
    * filePath: path of file to read from
    * returns: list of strings as rows of file*/
    public List<List<String>> parse(String resourcePath) {
        List<List<String>> rows = new ArrayList<>();

        try (InputStream in = getClass().getClassLoader().getResourceAsStream(resourcePath)) {

            if (in == null) {
                System.err.println("Resource not found on classpath: " + resourcePath);
                return rows;
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
                String line;
                boolean headerSkipped = false;

                while ((line = br.readLine()) != null) {
                    if (line.trim().isEmpty() || line.startsWith("//")) continue;
                    if (!headerSkipped && line.contains("/")) {
                        headerSkipped = true;
                        continue;
                    }
                    rows.add(Arrays.asList(line.split("\\s+")));
                }
            }
        } catch (Exception e) {
            System.err.println("Error reading resource: " + resourcePath);
            e.printStackTrace();
        }

        return rows;
    }
}
