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

    @Test
    void lambdaWithMultipleOperations_subtract() {
        IntegerOperation subtract = (a, b) -> a - b;

        assertEquals(10, subtract.apply(30, 20));
        assertEquals(-10, subtract.apply(20, 30));
        assertEquals(0, subtract.apply(15, 15));
    }

    @Test
    void lambdaWithMultipleOperations_multiply() {
        IntegerOperation multiply = (a, b) -> a * b;

        assertEquals(200, multiply.apply(10, 20));
        assertEquals(0, multiply.apply(0, 100));
        assertEquals(-50, multiply.apply(5, -10));
    }

    @Test
    void lambdaWithMultipleOperations_divide() {
        IntegerOperation divide = (a, b) -> a / b;

        assertEquals(5, divide.apply(100, 20));
        assertEquals(2, divide.apply(10, 5));
        assertEquals(-3, divide.apply(-15, 5));
    }

    @Test
    void lambdaWithMultipleOperations_modulo() {
        IntegerOperation modulo = (a, b) -> a % b;

        assertEquals(1, modulo.apply(10, 3));
        assertEquals(0, modulo.apply(10, 5));
        assertEquals(2, modulo.apply(17, 5));
    }

    @Test
    void lambdaWithMultipleOperations_power() {
        IntegerOperation power = (a, b) -> (int) Math.pow(a, b);

        assertEquals(8, power.apply(2, 3));
        assertEquals(100, power.apply(10, 2));
        assertEquals(1, power.apply(5, 0));
    }

    @Test
    void lambdaWithMultipleOperations_max() {
        IntegerOperation max = Math::max;

        assertEquals(20, max.apply(10, 20));
        assertEquals(20, max.apply(20, 10));
        assertEquals(0, max.apply(-5, 0));
    }

    @Test
    void lambdaWithMultipleOperations_min() {
        IntegerOperation min = Math::min;

        assertEquals(10, min.apply(10, 20));
        assertEquals(10, min.apply(20, 10));
        assertEquals(-5, min.apply(-5, 0));
    }

    @Test
    void lambdaWithComplexExpression() {
        IntegerOperation complex = (a, b) -> (a * 2) + (b * 3);

        assertEquals(50, complex.apply(10, 10));
        assertEquals(0, complex.apply(0, 0));
        assertEquals(-10, complex.apply(-2, -2));
    }

    @Test
    void lambdaWithConditionalLogic() {
        IntegerOperation conditional = (a, b) -> a > b ? a : b;

        assertEquals(20, conditional.apply(10, 20));
        assertEquals(20, conditional.apply(20, 10));
        assertEquals(15, conditional.apply(15, 15));
    }

    @Test
    void chainedLambdaOperations() {
        IntegerOperation sum = (a, b) -> a + b;
        int result = sum.apply(sum.apply(5, 5), sum.apply(10, 10));

        assertEquals(30, result);
    }

    @Test
    void binaryOperator_withLargeNumbers() {
        BinaryOperator<Integer> sum = Integer::sum;

        assertEquals(2000000000, sum.apply(1000000000, 1000000000));
        assertEquals(Integer.MAX_VALUE, sum.apply(Integer.MAX_VALUE, 0));
    }

    @Test
    void intBinaryOperator_withNegativeLargeNumbers() {
        IntBinaryOperator sum = Integer::sum;

        assertEquals(-2000000000, sum.applyAsInt(-1000000000, -1000000000));
        assertEquals(Integer.MIN_VALUE, sum.applyAsInt(Integer.MIN_VALUE, 0));
    }

    @Test
    void lambdaWithAbsoluteValue() {
        IntegerOperation absSum = (a, b) -> Math.abs(a) + Math.abs(b);

        assertEquals(30, absSum.apply(-10, -20));
        assertEquals(30, absSum.apply(10, 20));
        assertEquals(30, absSum.apply(-10, 20));
    }

    @Test
    void lambdaAsParameter_withMultipleChainedCalls() {
        int result1 = calculate(5, 3, (a, b) -> a + b);
        int result2 = calculate(result1, 2, (a, b) -> a * b);

        assertEquals(16, result2);
    }

    @Test
    void methodReference_multipleOperations() {
        IntegerOperation sumRef = Integer::sum;
        IntegerOperation maxRef = Integer::max;
        IntegerOperation minRef = Integer::min;

        assertEquals(15, sumRef.apply(7, 8));
        assertEquals(8, maxRef.apply(7, 8));
        assertEquals(7, minRef.apply(7, 8));
    }

    @Test
    void lambdaWithBitwiseOperations_and() {
        IntegerOperation bitwiseAnd = (a, b) -> a & b;

        assertEquals(0, bitwiseAnd.apply(5, 10));
        assertEquals(8, bitwiseAnd.apply(12, 10));
    }

    @Test
    void lambdaWithBitwiseOperations_or() {
        IntegerOperation bitwiseOr = (a, b) -> a | b;

        assertEquals(15, bitwiseOr.apply(5, 10));
        assertEquals(14, bitwiseOr.apply(12, 10));
    }

    @Test
    void lambdaWithBitwiseOperations_xor() {
        IntegerOperation bitwiseXor = (a, b) -> a ^ b;

        assertEquals(15, bitwiseXor.apply(5, 10));
        assertEquals(6, bitwiseXor.apply(12, 10));
    }

    @Test
    void lambdaCompositionPattern() {
        IntegerOperation addTen = (a, b) -> a + 10;
        IntegerOperation result = (a, b) -> addTen.apply(a, b) + addTen.apply(a, b);

        assertEquals(30, result.apply(5, 0));
    }

    @Test
    void binaryOperator_identityFunction() {
        BinaryOperator<Integer> returnFirst = (a, b) -> a;
        BinaryOperator<Integer> returnSecond = (a, b) -> b;

        assertEquals(10, returnFirst.apply(10, 20));
        assertEquals(20, returnSecond.apply(10, 20));
    }

    @Test
    void intBinaryOperator_averageOfTwoNumbers() {
        IntBinaryOperator average = (a, b) -> (a + b) / 2;

        assertEquals(15, average.applyAsInt(10, 20));
        assertEquals(0, average.applyAsInt(-5, 5));
        assertEquals(50, average.applyAsInt(30, 70));
    }

    @Test
    void lambdaWithNestedConditionals() {
        IntegerOperation nestedLogic = (a, b) -> {
            if (a > 0 && b > 0) return a + b;
            if (a < 0 && b < 0) return a * b;
            return Math.abs(a - b);
        };

        assertEquals(30, nestedLogic.apply(10, 20));
        assertEquals(50, nestedLogic.apply(-5, -10));
        assertEquals(15, nestedLogic.apply(-5, 10));
    }

    @Test
    void customFunctionalInterface_withZeroDivision() {
        IntegerOperation safeDivide = (a, b) -> b != 0 ? a / b : 0;

        assertEquals(5, safeDivide.apply(10, 2));
        assertEquals(0, safeDivide.apply(10, 0));
    }

    @Test
    void lambdaExpressionReusability() {
        IntegerOperation sum = (a, b) -> a + b;

        assertEquals(15, sum.apply(5, 10));
        assertEquals(30, sum.apply(15, 15));
        assertEquals(100, sum.apply(50, 50));
        assertEquals(0, sum.apply(-10, 10));
    }

    /**
     * Helper method that accepts a lambda expression as a parameter
     */
    private int calculate(int a, int b, IntegerOperation operator) {
        return operator.apply(a, b);
    }
}

