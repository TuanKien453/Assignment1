
package classes;
import java.util.*;


public class Inputer {
    private final static Scanner scanner = new Scanner(System.in);

    public static int inputInt(String msg,int min, int max) {
        int number;
        while (true) {
            try {
                System.out.print(msg);
                number = scanner.nextInt();
                scanner.nextLine();
                if (number >= min && number <= max) {
                    break;
                } else {
                    System.out.println("Error: Input must be between " + min + " and " + max + ". Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: You must enter an integer. Please try again.");
                scanner.nextLine();
            }
        }
        return number;
    }

    public static String inputString(String msg) {
        String input;
        while (true) {
            try {
                System.out.print(msg);
                input = scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: You must enter a string. Please try again.");
                scanner.nextLine();
            }
        }
        return input.trim();
    }
        public static String inputPattern(String msg,String inputPattern) {
        String input;
        while (true) {
            try {
                System.out.print(msg);
                input = scanner.nextLine();
                input = input.trim();
                if (input.matches(inputPattern)) {
                    break;
                } else {
                    System.out.println("Error: String does not match pattern. Please try again");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: You must enter a string. Please try again.");
                scanner.nextLine();
            }
        }
        return input;
    }
    
}