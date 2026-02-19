package lambda.example004;

/**
 * A complete Java program demonstrating lambda expressions to find the sum of two integers.
 * This program shows multiple approaches to using lambda expressions for integer addition.
 */
public class SumTwoIntegersProgram {

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
        int result4 = SumTwoIntegersProgramHelper.calculate(50, 60, (a, b) -> a + b);
        System.out.println("50 + 60 = " + result4);

        // Approach 5: Using method reference
        System.out.println("\nApproach 5: Method Reference");
        IntegerOperation methodRefSum = Integer::sum;
        int result5 = methodRefSum.apply(70, 80);
        System.out.println("70 + 80 = " + result5);

        // Demonstrate with different numbers
        System.out.println("\n=== Additional Examples ===");
        SumTwoIntegersProgramHelper.demonstrateWithDifferentNumbers(sumOperator);
    }

}





