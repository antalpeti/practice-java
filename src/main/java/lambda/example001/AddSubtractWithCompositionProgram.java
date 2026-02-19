package lambda.example001;

import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

/**
 * A complete Java program demonstrating lambda expressions with function composition
 * to add two integers and then subtract a third value.
 * This program shows multiple approaches to composing lambda functions.
 */
public class AddSubtractWithCompositionProgram {

    public static void main(String[] args) {
        System.out.println("=== Lambda Expression with Function Composition ===\n");

        // Approach 1: Manual function composition with lambda
        System.out.println("Approach 1: Manual Function Composition");
        int addResult = 10 + 20;
        int finalResult1 = addResult - 5;
        System.out.println("(10 + 20) - 5 = " + finalResult1);

        // Approach 2: Using IntBinaryOperator for addition and IntUnaryOperator for subtraction
        System.out.println("\nApproach 2: Separate Operations with Lambda");
        IntBinaryOperator add = (a, b) -> a + b;
        IntUnaryOperator subtractFive = x -> x - 5;
        int result2 = subtractFive.applyAsInt(add.applyAsInt(10, 20));
        System.out.println("(10 + 20) - 5 = " + result2);

        // Approach 3: Function composition returning a function
        System.out.println("\nApproach 3: Function Composition Returning a Function");
        IntegerOperationComposer composedOperation = (a, b) -> (c) -> a + b - c;
        IntUnaryOperator operation = composedOperation.apply(15, 25);
        int result3 = operation.applyAsInt(8);
        System.out.println("(15 + 25) - 8 = " + result3);

        // Approach 4: Using a method that composes operations
        System.out.println("\nApproach 4: Composed Function via Method");
        int result4 = AddSubtractWithCompositionProgramHelper.composeAddAndSubtract(30, 40, 12);
        System.out.println("(30 + 40) - 12 = " + result4);

        // Approach 5: Using custom three-integer operation interface
        System.out.println("\nApproach 5: Three-Integer Operation with Lambda");
        ThreeIntegerOperation addThenSubtract = (a, b, c) -> a + b - c;
        int result5 = addThenSubtract.apply(45, 35, 20);
        System.out.println("(45 + 35) - 20 = " + result5);

        // Approach 6: Method reference and composition
        System.out.println("\nApproach 6: Method Reference with Composition");
        int result6 = AddSubtractWithCompositionProgramHelper.composeWithMethodReference(50, 60, 25);
        System.out.println("(50 + 60) - 25 = " + result6);

        // Approach 7: Advanced composition with chaining
        System.out.println("\nApproach 7: Advanced Function Chain Composition");
        IntBinaryOperator addOperator = (a, b) -> a + b;
        int sum = addOperator.applyAsInt(70, 30);
        IntUnaryOperator subtractOperator = (x) -> x - 15;
        int result7 = subtractOperator.applyAsInt(sum);
        System.out.println("(70 + 30) - 15 = " + result7);

        // Demonstrate with various test cases
        System.out.println("\n=== Additional Examples ===");
        AddSubtractWithCompositionProgramHelper.demonstrateWithDifferentNumbers(addThenSubtract);
    }

}

