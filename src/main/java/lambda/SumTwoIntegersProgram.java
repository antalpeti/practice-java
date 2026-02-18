package lambda;

/**
 * A complete Java program demonstrating lambda expressions to find the sum of two integers.
 * This program shows multiple approaches to using lambda expressions for integer addition.
 */
public class SumTwoIntegersProgram {

    /**
     * Custom functional interface for integer operations
     */
    @FunctionalInterface
    interface IntegerOperation {
        int apply(int a, int b);
    }

    public static void main(String[] args) {
        System.out.println("=== Lambda Expression to Sum Two Integers ===\n");

        // Approach 1: Using custom functional interface
        System.out.println("Approach 1: Custom Functional Interface");
        IntegerOperation sumOperator = (a, b) -> a + b;
        int result1 = sumOperator.apply(10, 20);
        System.out.println("10 + 20 = " + result1);

        // Approach 2: Using Java's built-in IntBinaryOperator
        System.out.println("\nApproach 2: IntBinaryOperator");
        java.util.function.IntBinaryOperator intSum = (a, b) -> a + b;
        int result2 = intSum.applyAsInt(15, 25);
        System.out.println("15 + 25 = " + result2);

        // Approach 3: Using BinaryOperator with Integer wrapper
        System.out.println("\nApproach 3: BinaryOperator<Integer>");
        java.util.function.BinaryOperator<Integer> integerSum = (a, b) -> a + b;
        int result3 = integerSum.apply(30, 40);
        System.out.println("30 + 40 = " + result3);

        // Approach 4: Method that accepts lambda as parameter
        System.out.println("\nApproach 4: Lambda as Method Parameter");
        int result4 = calculate(50, 60, (a, b) -> a + b);
        System.out.println("50 + 60 = " + result4);

        // Approach 5: Using method reference
        System.out.println("\nApproach 5: Method Reference");
        IntegerOperation methodRefSum = Integer::sum;
        int result5 = methodRefSum.apply(70, 80);
        System.out.println("70 + 80 = " + result5);

        // Demonstrate with different numbers
        System.out.println("\n=== Additional Examples ===");
        demonstrateWithDifferentNumbers(sumOperator);
    }

    /**
     * Method that accepts a lambda expression as a parameter
     */
    private static int calculate(int a, int b, IntegerOperation operator) {
        return operator.apply(a, b);
    }

    /**
     * Demonstrates the lambda with various test cases
     */
    private static void demonstrateWithDifferentNumbers(IntegerOperation operator) {
        System.out.println("Positive numbers: 100 + 200 = " + operator.apply(100, 200));
        System.out.println("Negative numbers: -50 + -30 = " + operator.apply(-50, -30));
        System.out.println("Mixed numbers: 45 + (-20) = " + operator.apply(45, -20));
        System.out.println("With zero: 0 + 99 = " + operator.apply(0, 99));
        System.out.println("Large numbers: 999999 + 1 = " + operator.apply(999999, 1));
    }
}





