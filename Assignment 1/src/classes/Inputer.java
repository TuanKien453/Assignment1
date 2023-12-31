package classes;

import java.util.*;

public class Inputer {

    private final static Scanner scanner = new Scanner(System.in);

    //DEV by Hoàng Tuấn Kiên 
    public static int inputInt(String msg, int min, int max) {
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

    //DEV by Hoàng Tuấn Kiên 
    public static int menuChoice(String msg, int min, int max) {
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
                System.out.println("Invalid choice. Please choose again.");
                scanner.nextLine();
            }
        }
        return number;
    }

    //DEV by Hoàng Tuấn Kiên 
    public static Double inputDouble(String msg, Double min, Double max) {
        Double number;
        while (true) {
            try {
                System.out.print(msg);
                number = scanner.nextDouble();
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

    //DEV by Hoàng Tuấn Kiên 
    public static String inputString(String msg) {
        String input;
        while (true) {
            try {
                System.out.print(msg);
                input = scanner.nextLine();
                if (input.length() == 0) {
                    System.out.println("String cannot be empty");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: You must enter a string. Please try again.");
                scanner.nextLine();
            }
        }
        return input.trim();
    }
    //DEV by Hoàng Tuấn Kiên 

    public static String inputEnter(String msg) {
        String input;
        while (true) {
            try {
                System.out.print(msg);
                input = scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: You must enter, Please try again.");
                scanner.nextLine();
            }
        }
        return input.trim();
    }

    //DEV by Hoàng Tuấn Kiên 
    public static String inputPattern(String msg, String inputPattern) {
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
