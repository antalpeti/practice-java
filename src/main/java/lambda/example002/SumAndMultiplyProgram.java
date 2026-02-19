package lambda.example002;

/**
 * A Java program demonstrating lambda expressions that add two integers
 * and then multiply the result by a constant factor.
 * This showcases function composition and lambda chaining.
 */
public class SumAndMultiplyProgram {

    // Constant factor for multiplication
    private static final int DEFAULT_FACTOR = 3;

    public static void main(String[] args) {
        System.out.println("=== Lambda: Add Two Integers and Multiply by Factor ===\n");

        // Approach 1: Simple lambda with inline factor
        System.out.println("Approach 1: Lambda with Inline Factor");
        IntegerOperationWithFactor sumAndMultiply = (a, b, factor) -> (a + b) * factor;
        int result1 = sumAndMultiply.apply(10, 20, 5);
        System.out.println("(10 + 20) * 5 = " + result1);

        // Approach 2: Lambda with constant factor (closure)
        System.out.println("\nApproach 2: Lambda with Constant Factor (Closure)");
        int constantFactor = DEFAULT_FACTOR;
        TwoStepOperation sumAndMultiplyByConstant = (a, b) -> (a + b) * constantFactor;
        int result2 = sumAndMultiplyByConstant.execute(15, 25);
        System.out.println("(15 + 25) * " + constantFactor + " = " + result2);

        // Approach 3: Using Java's built-in functional interfaces
        System.out.println("\nApproach 3: Using IntBinaryOperator and IntUnaryOperator");
        java.util.function.IntBinaryOperator sum = (a, b) -> a + b;
        java.util.function.IntUnaryOperator multiplyByFactor = x -> x * DEFAULT_FACTOR;
        int tempSum = sum.applyAsInt(30, 40);
        int result3 = multiplyByFactor.applyAsInt(tempSum);
        System.out.println("(30 + 40) * " + DEFAULT_FACTOR + " = " + result3);

        // Approach 4: Function composition
        System.out.println("\nApproach 4: Function Composition");
        int result4 = SumAndMultiplyProgramHelper.composedOperation(50, 60, DEFAULT_FACTOR);
        System.out.println("(50 + 60) * " + DEFAULT_FACTOR + " = " + result4);

        // Approach 5: Lambda as method parameter
        System.out.println("\nApproach 5: Lambda as Method Parameter");
        int result5 = SumAndMultiplyProgramHelper.executeOperation(70, 80, 2, (a, b, f) -> (a + b) * f);
        System.out.println("(70 + 80) * 2 = " + result5);

        // Approach 6: Creating a factory method for different factors
        System.out.println("\nApproach 6: Factory Method for Different Factors");
        TwoStepOperation doubler = SumAndMultiplyProgramHelper.createSumAndMultiplyOperation(2);
        TwoStepOperation tripler = SumAndMultiplyProgramHelper.createSumAndMultiplyOperation(3);
        TwoStepOperation quadrupler = SumAndMultiplyProgramHelper.createSumAndMultiplyOperation(4);

        int baseA = 10;
        int baseB = 5;
        System.out.println("(" + baseA + " + " + baseB + ") * 2 = " + doubler.execute(baseA, baseB));
        System.out.println("(" + baseA + " + " + baseB + ") * 3 = " + tripler.execute(baseA, baseB));
        System.out.println("(" + baseA + " + " + baseB + ") * 4 = " + quadrupler.execute(baseA, baseB));

        // Demonstrate with various test cases
        System.out.println("\n=== Additional Examples ===");
        SumAndMultiplyProgramHelper.demonstrateWithDifferentInputs(sumAndMultiply);
    }

}

