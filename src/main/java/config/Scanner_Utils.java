package config;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Scanner_Utils {
    public static int intScanner(Scanner scanner) {
        while (true) {
            try {
                return Math.abs(scanner.nextInt());
            } catch (InputMismatchException e) {
                System.err.println("Error: Please Enter a Valid Integer Value.");
                scanner.nextLine();
            }
        }
    }

    public static double doubleScanner(Scanner scanner) {
        while (true) {
            try {
                return Math.abs(scanner.nextDouble());
            } catch (InputMismatchException e) {
                System.err.println("Error: Please Enter a Valid Double Value.");
                scanner.nextLine();
            }
        }
    }

}
