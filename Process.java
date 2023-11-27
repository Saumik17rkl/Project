/**
 * The Process class is a Java program that takes an alpha-numeric string as input, processes it by
 * separating numbers and alphabets, and performs various operations on them.
 */
import java.util.Scanner;

public class Process {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===================================");
        System.out.println("=== Welcome to Program ===");
        System.out.println("===================================");

        System.out.print("Enter an alpha-numeric string: ");
        String userInput = scanner.nextLine();

        handleInputCase(userInput);

        // Close the scanner to prevent resource leaks
        scanner.close();
    }

    private static void handleInputCase(String inputStr) {
        System.out.println("\n--- Processing Input ---");
        for (char ch : inputStr.toCharArray()) {
            String charType = isNumberOrAlphabet(ch);
            if (charType.equals("number")) {
                System.out.println("Number: " + ch);
            } else if (charType.equals("alphabet")) {
                System.out.println("Alphabet: " + ch);
            }
        }

        processAlphaNumeric(inputStr);
    }

    private static String isNumberOrAlphabet(char ch) {
        if (Character.isDigit(ch)) {
            return "number";
        } else if (Character.isAlphabetic(ch)) {
            return "alphabet";
        } else {
            return "other";
        }
    }

    private static void processAlphaNumeric(String inputStr) {
        try {
            StringBuilder numbersBuilder = new StringBuilder();
            StringBuilder alphabetsBuilder = new StringBuilder();

            for (char ch : inputStr.toCharArray()) {
                if (Character.isDigit(ch)) {
                    numbersBuilder.append(ch);
                } else if (Character.isAlphabetic(ch)) {
                    alphabetsBuilder.append(ch);
                }
            }

            String numbers = numbersBuilder.toString();
            String alphabets = alphabetsBuilder.toString();

            if (!numbers.isEmpty()) {
                performNumberOperations(numbers);
            }

            if (!alphabets.isEmpty()) {
                performAlphabetOperations(alphabets);
            }

            System.out.println("\n--- Processing Completed Successfully ---");
        } catch (Exception e) {
            System.out.println("Error: Invalid input for alpha-numeric processing.");
        }
    }

    private static void performNumberOperations(String numbers) {
        try {
            int additionResult = 0;
            int multiplicationResult = 1;
            int subtractionResult = Character.getNumericValue(numbers.charAt(0));

            for (char digit : numbers.toCharArray()) {
                int num = Character.getNumericValue(digit);
                additionResult += num;
                multiplicationResult *= num;
                subtractionResult -= num;
            }

            String reversedNumbers = new StringBuilder(numbers).reverse().toString();

            System.out.println("\n--- Number Processing ---");
            System.out.println("Original Numbers: " + numbers);
            System.out.println("Reversed Numbers: " + reversedNumbers);
            System.out.println("Addition of Numbers: " + additionResult);
            System.out.println("Multiplication of Numbers: " + multiplicationResult);
            System.out.println("Subtraction of Numbers: " + subtractionResult);
        } catch (Exception e) {
            System.out.println("Error: Invalid input for number processing.");
        }
    }

    private static void performAlphabetOperations(String alphabets) {
        try {
            String convertedAlphabets = swapCase(alphabets);
            String reversedAlphabets = new StringBuilder(alphabets).reverse().toString();

            System.out.println("\n--- Alphabet Processing ---");
            System.out.println("Original Alphabets: " + alphabets);
            System.out.println("Converted Alphabet Case: " + convertedAlphabets);
            System.out.println("Reversed Alphabets: " + reversedAlphabets);

            System.out.println("\nASCII Values:");
            for (char ch : alphabets.toCharArray()) {
                System.out.println(ch + ": " + (int) ch);
            }

            System.out.println("\nReversed ASCII Values:");
            for (char ch : reversedAlphabets.toCharArray()) {
                System.out.println(ch + ": " + (int) ch);
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid input for alphabet processing.");
        }
    }

    private static String swapCase(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (Character.isUpperCase(ch)) {
                chars[i] = Character.toLowerCase(ch);
            } else if (Character.isLowerCase(ch)) {
                chars[i] = Character.toUpperCase(ch);
            }
        }
        return new String(chars);
    }
}
