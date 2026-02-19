package lambda.example004;

public class SumTwoIntegersProgramHelper {

  /**
   * Method that accepts a lambda expression as a parameter
   */
  static int calculate(int a, int b, IntegerOperation operator) {
    return operator.apply(a, b);
  }

  /**
   * Demonstrates the lambda with various test cases
   */
  static void demonstrateWithDifferentNumbers(IntegerOperation operator) {
      System.out.println("Positive numbers: 100 + 200 = " + operator.apply(100, 200));
      System.out.println("Negative numbers: -50 + -30 = " + operator.apply(-50, -30));
      System.out.println("Mixed numbers: 45 + (-20) = " + operator.apply(45, -20));
      System.out.println("With zero: 0 + 99 = " + operator.apply(0, 99));
      System.out.println("Large numbers: 999999 + 1 = " + operator.apply(999999, 1));
  }
}
