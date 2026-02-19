package lambda.example002;

/**
 * Custom functional interface for operations with two integers and a factor
 */
@FunctionalInterface
interface IntegerOperationWithFactor {

  int apply(int a, int b, int factor);
}
