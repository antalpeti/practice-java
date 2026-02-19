package lambda.example003;

import java.io.IOException;

/**
 * A Java program that reads two integers from a file, uses a lambda expression
 * to sum them, and returns the result.
 *
 * File format: Two integers separated by whitespace (space, newline, or tab)
 * Example:
 * 10 20
 * or
 * 10
 * 20
 */
public class SumFromFileProgram {

    /**
     * Demonstrates various approaches to reading and summing integers from files
     */
    public static void main(String[] args) {
        System.out.println("=== Sum Two Integers from File using Lambda ===\n");

        // Create sample files for demonstration
        try {
            SumFromFileProgramHelper.createSampleFiles();

            // Example 1: Simple file with two numbers on one line
            System.out.println("Example 1: Two numbers on one line");
            String file1 = "target/numbers1.txt";
            int sum1 = SumFromFileProgramHelper.sumIntegersFromFile(file1);
            System.out.println("File: " + file1);
            System.out.println("Result: " + sum1);

            // Example 2: Two numbers on separate lines
            System.out.println("\nExample 2: Two numbers on separate lines");
            String file2 = "target/numbers2.txt";
            int sum2 = SumFromFileProgramHelper.sumIntegersFromFile(file2);
            System.out.println("File: " + file2);
            System.out.println("Result: " + sum2);

            // Example 3: Using Stream API approach
            System.out.println("\nExample 3: Using Stream API");
            int sum3 = SumFromFileProgramHelper.sumIntegersFromFileStream(file1);
            System.out.println("Result: " + sum3);

            // Example 4: Multiple pairs
            System.out.println("\nExample 4: Multiple pairs of numbers");
            String file3 = "target/numbers3.txt";
            int[] results = SumFromFileProgramHelper.sumMultiplePairsFromFile(file3);
            System.out.println("File: " + file3);
            System.out.println("Results: ");
            for (int i = 0; i < results.length; i++) {
                System.out.println("  Pair " + (i + 1) + ": " + results[i]);
            }

            // Example 5: Negative numbers
            System.out.println("\nExample 5: Negative numbers");
            String file4 = "target/numbers4.txt";
            int sum4 = SumFromFileProgramHelper.sumIntegersFromFile(file4);
            System.out.println("File: " + file4);
            System.out.println("Result: " + sum4);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}

