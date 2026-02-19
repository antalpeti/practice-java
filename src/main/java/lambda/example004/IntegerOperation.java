package lambda.example004;

/**
 * Custom functional interface for integer operations
 */
@FunctionalInterface
interface IntegerOperation {

  int apply(int a, int b);
}
