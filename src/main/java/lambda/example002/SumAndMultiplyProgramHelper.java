package lambda.example002;

public class SumAndMultiplyProgramHelper {

  /**
   * Performs the operation using function composition approach
   */
  static int composedOperation(int a, int b, int factor) {
    java.util.function.IntBinaryOperator sum = (x, y) -> x + y;
    java.util.function.IntUnaryOperator multiply = x -> x * factor;

    return multiply.applyAsInt(sum.applyAsInt(a, b));
  }

  /**
   * Method that accepts a lambda expression with factor as a parameter
   */
  static int executeOperation(int a, int b, int factor, IntegerOperationWithFactor operation) {
      return operation.apply(a, b, factor);
  }

  /**
   * Factory method that creates a lambda with a specific factor
   * Demonstrates closure where the factor is captured by the lambda
   */
  static TwoStepOperation createSumAndMultiplyOperation(int factor) {
      return (a, b) -> (a + b) * factor;
  }

  /**
   * Demonstrates the lambda with various test cases
   */
  static void demonstrateWithDifferentInputs(IntegerOperationWithFactor operation) {
      System.out.println("Positive numbers: (100 + 200) * 2 = "
          + operation.apply(100, 200, 2));
      System.out.println("Negative numbers: (-50 + -30) * 3 = "
          + operation.apply(-50, -30, 3));
      System.out.println("Mixed numbers: (45 + (-20)) * 4 = "
          + operation.apply(45, -20, 4));
      System.out.println("With zero: (0 + 99) * 5 = "
          + operation.apply(0, 99, 5));
      System.out.println("Large numbers: (1000 + 2000) * 10 = "
          + operation.apply(1000, 2000, 10));
      System.out.println("Negative factor: (10 + 5) * (-2) = "
          + operation.apply(10, 5, -2));
  }
}
