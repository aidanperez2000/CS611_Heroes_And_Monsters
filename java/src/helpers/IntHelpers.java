package helpers;

import java.util.Scanner;

/*Helper class for parsing ints*/
public class IntHelpers {

    /*Helper function which parses an int from input
    * scanner: scanner to read input
    * returns: int from input*/
    public static int getInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            }
            catch (NumberFormatException e) {
                System.out.println("Enter a valid number.");
            }
        }
    }
}
