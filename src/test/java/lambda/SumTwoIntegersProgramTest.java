package lambda;

import org.junit.jupiter.api.Test;

import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for lambda expressions used to sum two integers
 */
class SumTwoIntegersProgramTest {

    /**
     * Inner functional interface for testing
     */
    @FunctionalInterface
    interface IntegerOperation {
        int apply(int a, int b);
    }

    @Test
    void customFunctionalInterface_sumsIntegers() {
        IntegerOperation sumOperator = (a, b) -> a + b;

        assertEquals(30, sumOperator.apply(10, 20));
        assertEquals(0, sumOperator.apply(-5, 5));
        assertEquals(-10, sumOperator.apply(-3, -7));
    }

    @Test
    void intBinaryOperator_sumsIntegers() {
        IntBinaryOperator intSum = (a, b) -> a + b;

        assertEquals(40, intSum.applyAsInt(15, 25));
        assertEquals(100, intSum.applyAsInt(60, 40));
        assertEquals(0, intSum.applyAsInt(0, 0));
    }

    @Test
    void binaryOperator_sumsIntegers() {
        BinaryOperator<Integer> integerSum = (a, b) -> a + b;

        assertEquals(70, integerSum.apply(30, 40));
        assertEquals(150, integerSum.apply(75, 75));
        assertEquals(-20, integerSum.apply(-10, -10));
    }

    @Test
    void lambdaAsParameter_sumsIntegers() {
        int result = calculate(50, 60, (a, b) -> a + b);

        assertEquals(110, result);
    }

    @Test
    void lambdaAsParameter_withDifferentOperations() {
        assertEquals(20, calculate(10, 10, (a, b) -> a + b));
        assertEquals(100, calculate(10, 10, (a, b) -> a * b));
        assertEquals(0, calculate(10, 10, (a, b) -> a - b));
        assertEquals(10, calculate(10, 10, (a, b) -> Math.max(a, b)));
    }

    @Test
    void methodReference_sumsIntegers() {
        IntegerOperation methodRefSum = Integer::sum;

        assertEquals(150, methodRefSum.apply(70, 80));
        assertEquals(50, methodRefSum.apply(25, 25));
        assertEquals(1000, methodRefSum.apply(999, 1));
    }

    @Test
    void sumWithPositiveNumbers() {
        IntegerOperation sum = (a, b) -> a + b;

        assertEquals(300, sum.apply(100, 200));
        assertEquals(1000000, sum.apply(999999, 1));
    }

    @Test
    void sumWithNegativeNumbers() {
        IntegerOperation sum = (a, b) -> a + b;

        assertEquals(-80, sum.apply(-50, -30));
        assertEquals(-100, sum.apply(-25, -75));
    }

    @Test
    void sumWithMixedNumbers() {
        IntegerOperation sum = (a, b) -> a + b;

        assertEquals(25, sum.apply(45, -20));
        assertEquals(-5, sum.apply(10, -15));
    }

    @Test
    void sumWithZero() {
        IntegerOperation sum = (a, b) -> a + b;

        assertEquals(99, sum.apply(0, 99));
        assertEquals(99, sum.apply(99, 0));
        assertEquals(0, sum.apply(0, 0));
    }

    @Test
    void integerSumMethodReference() {
        IntBinaryOperator sum = Integer::sum;

        assertEquals(15, sum.applyAsInt(7, 8));
        assertEquals(0, sum.applyAsInt(-10, 10));
        assertEquals(100, sum.applyAsInt(50, 50));
    }

    /**
     * Helper method that accepts a lambda expression as a parameter
     */
    private int calculate(int a, int b, IntegerOperation operator) {
        return operator.apply(a, b);
    }
}

