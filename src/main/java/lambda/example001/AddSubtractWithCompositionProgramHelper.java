package lambda.example001;

import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

public class AddSubtractWithCompositionProgramHelper {

  /**
   * Method that composes add and subtract operations
   */
  public static int testComposeAddAndSubtract(int a, int b, int c) {
    IntBinaryOperator add = (x, y) -> x + y;
    IntUnaryOperator subtract = (result) -> result - c;
    return subtract.applyAsInt(add.applyAsInt(a, b));
  }

  /**
   * Method using method reference with Integer::sum and lambda subtraction
   */
  public static int testComposeWithMethodReference(int a, int b, int c) {
      // Integer::sum is a method reference for addition
      int sum = Integer.sum(a, b);
      // Lambda for subtraction
      IntUnaryOperator subtract = (result) -> result - c;
      return subtract.applyAsInt(sum);
  }

  /**
   * Private method used by main - internal wrapper for testComposeAddAndSubtract
   */
  static int composeAddAndSubtract(int a, int b, int c) {
      return testComposeAddAndSubtract(a, b, c);
  }

  /**
   * Private method used by main - internal wrapper for testComposeWithMethodReference
   */
  static int composeWithMethodReference(int a, int b, int c) {
      return testComposeWithMethodReference(a, b, c);
  }

  /**
   * Demonstrates the lambda with various test cases
   */
  static void demonstrateWithDifferentNumbers(ThreeIntegerOperation operator) {
      System.out.println("Positive numbers: (100 + 200) - 50 = " + operator.apply(100, 200, 50));
      System.out.println("Negative numbers: (-50 + -30) - (-10) = " + operator.apply(-50, -30, -10));
      System.out.println("Mixed numbers: (75 + 25) - 40 = " + operator.apply(75, 25, 40));
      System.out.println("With zero: (0 + 100) - 0 = " + operator.apply(0, 100, 0));
      System.out.println("Large numbers: (999999 + 1) - 500000 = " + operator.apply(999999, 1, 500000));
      System.out.println("Result in zero: (50 + 50) - 100 = " + operator.apply(50, 50, 100));
      System.out.println("Negative result: (10 + 5) - 30 = " + operator.apply(10, 5, 30));
  }
}
