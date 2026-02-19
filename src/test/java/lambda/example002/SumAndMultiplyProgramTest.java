package lambda.example002;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Test class for SumAndMultiplyProgram
 * Tests various lambda expressions that add two integers and multiply by a factor
 */
class SumAndMultiplyProgramTest {

    /**
     * Functional interface for operations with two integers and a factor
     */
    @FunctionalInterface
    interface IntegerOperationWithFactor {
        int apply(int a, int b, int factor);
    }

    /**
     * Functional interface for a two-step operation with constant factor
     */
    @FunctionalInterface
    interface TwoStepOperation {
        int execute(int a, int b);
    }

    @Test
    void testSimpleSumAndMultiply() {
        // Lambda that adds two integers and multiplies by a factor
        IntegerOperationWithFactor sumAndMultiply = (a, b, factor) -> (a + b) * factor;

        assertEquals(150, sumAndMultiply.apply(10, 20, 5));
        assertEquals(120, sumAndMultiply.apply(15, 25, 3));
        assertEquals(0, sumAndMultiply.apply(10, 20, 0));
    }

    @Test
    void testWithConstantFactor() {
        // Lambda with constant factor captured in closure
        int constantFactor = 3;
        TwoStepOperation sumAndMultiplyByConstant = (a, b) -> (a + b) * constantFactor;

        assertEquals(120, sumAndMultiplyByConstant.execute(15, 25));
        assertEquals(90, sumAndMultiplyByConstant.execute(10, 20));
        assertEquals(297, sumAndMultiplyByConstant.execute(50, 49));
    }

    @Test
    void testWithNegativeNumbers() {
        IntegerOperationWithFactor sumAndMultiply = (a, b, factor) -> (a + b) * factor;

        assertEquals(-240, sumAndMultiply.apply(-50, -30, 3));
        assertEquals(50, sumAndMultiply.apply(45, -20, 2));
        assertEquals(-50, sumAndMultiply.apply(-10, -15, 2));
    }

    @Test
    void testWithNegativeFactor() {
        IntegerOperationWithFactor sumAndMultiply = (a, b, factor) -> (a + b) * factor;

        assertEquals(-60, sumAndMultiply.apply(10, 20, -2));
        assertEquals(-100, sumAndMultiply.apply(25, 25, -2));
        assertEquals(-30, sumAndMultiply.apply(-10, -5, 2));
    }

    @Test
    void testWithZero() {
        IntegerOperationWithFactor sumAndMultiply = (a, b, factor) -> (a + b) * factor;

        assertEquals(0, sumAndMultiply.apply(0, 0, 5));
        assertEquals(0, sumAndMultiply.apply(10, 20, 0));
        assertEquals(495, sumAndMultiply.apply(0, 99, 5));
        assertEquals(0, sumAndMultiply.apply(50, -50, 10));
    }

    @Test
    void testFunctionComposition() {
        // Using Java's built-in functional interfaces
        java.util.function.IntBinaryOperator sum = (a, b) -> a + b;
        java.util.function.IntUnaryOperator multiplyByFactor = x -> x * 3;

        int tempSum = sum.applyAsInt(30, 40);
        int result = multiplyByFactor.applyAsInt(tempSum);

        assertEquals(210, result);
    }

    @Test
    void testFactoryMethodWithDifferentFactors() {
        // Create operations with different factors
        TwoStepOperation doubler = createSumAndMultiplyOperation(2);
        TwoStepOperation tripler = createSumAndMultiplyOperation(3);
        TwoStepOperation quadrupler = createSumAndMultiplyOperation(4);

        assertEquals(30, doubler.execute(10, 5));
        assertEquals(45, tripler.execute(10, 5));
        assertEquals(60, quadrupler.execute(10, 5));
    }

    @Test
    void testLargeNumbers() {
        IntegerOperationWithFactor sumAndMultiply = (a, b, factor) -> (a + b) * factor;

        assertEquals(30000, sumAndMultiply.apply(1000, 2000, 10));
        assertEquals(3000000, sumAndMultiply.apply(999999, 1, 3));
    }

    @Test
    void testMethodParameterApproach() {
        int result = executeOperation(70, 80, 2, (a, b, f) -> (a + b) * f);
        assertEquals(300, result);

        result = executeOperation(100, 50, 5, (a, b, f) -> (a + b) * f);
        assertEquals(750, result);
    }

    /**
     * Helper method that accepts a lambda expression with factor as a parameter
     */
    private int executeOperation(int a, int b, int factor, IntegerOperationWithFactor operation) {
        return operation.apply(a, b, factor);
    }

    /**
     * Factory method that creates a lambda with a specific factor
     */
    private TwoStepOperation createSumAndMultiplyOperation(int factor) {
        return (a, b) -> (a + b) * factor;
    }

    @Test
    void testCommutativeProperty() {
        // Test that addition is commutative (a + b = b + a)
        IntegerOperationWithFactor sumAndMultiply = (a, b, factor) -> (a + b) * factor;

        int result1 = sumAndMultiply.apply(10, 20, 3);
        int result2 = sumAndMultiply.apply(20, 10, 3);

        assertEquals(result1, result2);
    }

    @Test
    void testAssociativeProperty() {
        // Test associative property: ((a + b) * f) = (a * f + b * f)
        IntegerOperationWithFactor sumAndMultiply = (a, b, factor) -> (a + b) * factor;

        int a = 10, b = 20, factor = 3;
        int result1 = sumAndMultiply.apply(a, b, factor);
        int result2 = (a * factor) + (b * factor);

        assertEquals(result1, result2);
    }
}

