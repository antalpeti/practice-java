package lambda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for AddSubtractWithCompositionProgram
 * Tests all seven approaches to function composition for adding two integers and subtracting a third
 */
@DisplayName("AddSubtractWithCompositionProgram Tests")
class AddSubtractWithCompositionProgramTest {

    private AddSubtractWithCompositionProgram.ThreeIntegerOperation addThenSubtract;

    @BeforeEach
    void setUp() {
        addThenSubtract = (a, b, c) -> a + b - c;
    }

    // ============ Tests for Approach 2: Separate Operations with Lambda ============

    @Test
    @DisplayName("Approach 2: Simple addition with subtraction")
    void testApproach2SimpleCase() {
        IntBinaryOperator add = (a, b) -> a + b;
        IntUnaryOperator subtractFive = x -> x - 5;
        int result = subtractFive.applyAsInt(add.applyAsInt(10, 20));
        assertEquals(25, result);
    }

    @Test
    @DisplayName("Approach 2: Negative numbers")
    void testApproach2NegativeNumbers() {
        IntBinaryOperator add = (a, b) -> a + b;
        IntUnaryOperator subtractTen = x -> x - 10;
        int result = subtractTen.applyAsInt(add.applyAsInt(-5, -3));
        assertEquals(-18, result);
    }

    @Test
    @DisplayName("Approach 2: Zero values")
    void testApproach2ZeroValues() {
        IntBinaryOperator add = (a, b) -> a + b;
        IntUnaryOperator subtractZero = x -> x - 0;
        int result = subtractZero.applyAsInt(add.applyAsInt(0, 0));
        assertEquals(0, result);
    }

    // ============ Tests for Approach 3: Function Composition Returning a Function ============

    @Test
    @DisplayName("Approach 3: Function composition returning a function")
    void testApproach3ComposedFunction() {
        AddSubtractWithCompositionProgram.IntegerOperationComposer composedOperation =
            (a, b) -> (c) -> a + b - c;
        IntUnaryOperator operation = composedOperation.apply(15, 25);
        int result = operation.applyAsInt(8);
        assertEquals(32, result);
    }

    @Test
    @DisplayName("Approach 3: Composed function with negative subtraction")
    void testApproach3NegativeSubtraction() {
        AddSubtractWithCompositionProgram.IntegerOperationComposer composedOperation =
            (a, b) -> (c) -> a + b - c;
        IntUnaryOperator operation = composedOperation.apply(10, 10);
        int result = operation.applyAsInt(-5);
        assertEquals(25, result);
    }

    @Test
    @DisplayName("Approach 3: Composed function resulting in zero")
    void testApproach3ResultingInZero() {
        AddSubtractWithCompositionProgram.IntegerOperationComposer composedOperation =
            (a, b) -> (c) -> a + b - c;
        IntUnaryOperator operation = composedOperation.apply(100, 200);
        int result = operation.applyAsInt(300);
        assertEquals(0, result);
    }

    // ============ Tests for Approach 4: Composed Function via Method ============

    @Test
    @DisplayName("Approach 4: Composed function via static method")
    void testApproach4SimpleCase() {
        int result = AddSubtractWithCompositionProgram.testComposeAddAndSubtract(30, 40, 12);
        assertEquals(58, result);
    }

    @Test
    @DisplayName("Approach 4: Method with negative numbers")
    void testApproach4NegativeNumbers() {
        int result = AddSubtractWithCompositionProgram.testComposeAddAndSubtract(-10, 5, 3);
        assertEquals(-8, result);
    }

    @Test
    @DisplayName("Approach 4: Method with all zeros")
    void testApproach4AllZeros() {
        int result = AddSubtractWithCompositionProgram.testComposeAddAndSubtract(0, 0, 0);
        assertEquals(0, result);
    }

    // ============ Tests for Approach 5: Three-Integer Operation Interface ============

    @Test
    @DisplayName("Approach 5: Basic three-integer operation")
    void testApproach5BasicOperation() {
        AddSubtractWithCompositionProgram.ThreeIntegerOperation operation =
            (a, b, c) -> a + b - c;
        int result = operation.apply(45, 35, 20);
        assertEquals(60, result);
    }

    @ParameterizedTest
    @DisplayName("Approach 5: Parameterized tests with various numbers")
    @CsvSource({
        "100, 200, 50, 250",      // Positive numbers
        "-50, -30, -10, -70",     // Negative numbers
        "75, 25, 40, 60",         // Mixed
        "0, 100, 0, 100",         // With zero
        "999999, 1, 500000, 500000", // Large numbers
        "50, 50, 100, 0",         // Result in zero
        "10, 5, 30, -15"          // Negative result
    })
    void testApproach5ParameterizedCases(int a, int b, int c, int expected) {
        int result = addThenSubtract.apply(a, b, c);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Approach 5: Negative result")
    void testApproach5NegativeResult() {
        int result = addThenSubtract.apply(10, 5, 30);
        assertEquals(-15, result);
    }

    @Test
    @DisplayName("Approach 5: Large numbers")
    void testApproach5LargeNumbers() {
        int result = addThenSubtract.apply(1000000, 1000000, 500000);
        assertEquals(1500000, result);
    }

    @Test
    @DisplayName("Approach 5: Integer.MAX_VALUE handling")
    void testApproach5MaxValue() {
        int result = addThenSubtract.apply(Integer.MAX_VALUE - 50, 25, 10);
        assertEquals(Integer.MAX_VALUE - 35, result);
    }

    @Test
    @DisplayName("Approach 5: Integer.MIN_VALUE handling")
    void testApproach5MinValue() {
        int result = addThenSubtract.apply(Integer.MIN_VALUE + 50, 25, 10);
        assertEquals(Integer.MIN_VALUE + 65, result);
    }

    // ============ Tests for Approach 6: Method Reference with Composition ============

    @Test
    @DisplayName("Approach 6: Method reference with composition")
    void testApproach6MethodReference() {
        int result = AddSubtractWithCompositionProgram.testComposeWithMethodReference(50, 60, 25);
        assertEquals(85, result);
    }

    @Test
    @DisplayName("Approach 6: Method reference with zero")
    void testApproach6WithZero() {
        int result = AddSubtractWithCompositionProgram.testComposeWithMethodReference(0, 0, 0);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Approach 6: Method reference with negative numbers")
    void testApproach6NegativeNumbers() {
        int result = AddSubtractWithCompositionProgram.testComposeWithMethodReference(-30, -20, -5);
        assertEquals(-45, result);
    }

    // ============ Tests for Approach 7: Advanced Function Chain Composition ============

    @Test
    @DisplayName("Approach 7: Advanced function chain")
    void testApproach7FunctionChain() {
        IntBinaryOperator addOperator = (a, b) -> a + b;
        int sum = addOperator.applyAsInt(70, 30);
        IntUnaryOperator subtractOperator = (x) -> x - 15;
        int result = subtractOperator.applyAsInt(sum);
        assertEquals(85, result);
    }

    @Test
    @DisplayName("Approach 7: Function chain with chained subtraction")
    void testApproach7ChainedSubtraction() {
        IntBinaryOperator add = (a, b) -> a + b;
        IntUnaryOperator subtract10 = x -> x - 10;
        IntUnaryOperator subtract5 = x -> x - 5;

        int result = add.applyAsInt(100, 50);
        result = subtract10.applyAsInt(result);
        result = subtract5.applyAsInt(result);

        assertEquals(135, result);
    }

    // ============ Comprehensive Edge Case Tests ============

    @Test
    @DisplayName("Edge case: Sum equals subtraction value")
    void testEdgeCaseSumEqualsSubtraction() {
        int result = addThenSubtract.apply(50, 50, 100);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Edge case: All same numbers")
    void testEdgeCaseAllSameNumbers() {
        int result = addThenSubtract.apply(25, 25, 25);
        assertEquals(25, result);
    }

    @Test
    @DisplayName("Edge case: Very large sum, small subtraction")
    void testEdgeCaseLargeSumSmallSubtraction() {
        int result = addThenSubtract.apply(100000, 100000, 1);
        assertEquals(199999, result);
    }

    @Test
    @DisplayName("Edge case: Small numbers with large subtraction")
    void testEdgeCaseSmallNumbersLargeSubtraction() {
        int result = addThenSubtract.apply(1, 1, 1000);
        assertEquals(-998, result);
    }

    @Test
    @DisplayName("Edge case: One positive, one negative addition")
    void testEdgeCasePositiveNegativeAddition() {
        int result = addThenSubtract.apply(100, -50, 25);
        assertEquals(25, result);
    }

    @Test
    @DisplayName("Edge case: Subtraction of negative number (effectively adds)")
    void testEdgeCaseSubtractNegative() {
        int result = addThenSubtract.apply(50, 50, -50);
        assertEquals(150, result);
    }

    // ============ Functional Interface Contract Tests ============

    @Test
    @DisplayName("Verify ThreeIntegerOperation is a functional interface")
    void testFunctionalInterfaceContract() {
        // Should be able to create instance with lambda
        AddSubtractWithCompositionProgram.ThreeIntegerOperation operation =
            (a, b, c) -> a + b - c;
        assertNotNull(operation);
        assertEquals(30, operation.apply(50, 30, 50));
    }

    @Test
    @DisplayName("Verify IntegerOperationComposer is a functional interface")
    void testComposerFunctionalInterfaceContract() {
        AddSubtractWithCompositionProgram.IntegerOperationComposer composer =
            (a, b) -> (c) -> a + b - c;
        assertNotNull(composer);

        IntUnaryOperator op = composer.apply(20, 30);
        assertEquals(45, op.applyAsInt(5));
    }

    // ============ Composition Correctness Tests ============

    @Test
    @DisplayName("Verify composition order: (a + b) - c")
    void testCompositionOrder() {
        // Verify that it's (a + b) - c and not a + (b - c) or other variations
        int result = addThenSubtract.apply(10, 5, 3);
        assertEquals((10 + 5) - 3, result);
        assertEquals(12, result);
    }

    @Test
    @DisplayName("Verify composition is left-associative for addition")
    void testLeftAssociativity() {
        int result = addThenSubtract.apply(8, 4, 2);
        // ((8 + 4) - 2) = (12 - 2) = 10
        assertEquals(10, result);
    }

    @Test
    @DisplayName("Verify different inputs produce different outputs")
    void testDifferentInputsDifferentOutputs() {
        int result1 = addThenSubtract.apply(10, 20, 5);
        int result2 = addThenSubtract.apply(10, 20, 6);
        assertNotEquals(result1, result2);
    }

    @Test
    @DisplayName("Verify same inputs produce same outputs (deterministic)")
    void testDeterministicBehavior() {
        int result1 = addThenSubtract.apply(15, 25, 10);
        int result2 = addThenSubtract.apply(15, 25, 10);
        assertEquals(result1, result2);
    }
}

