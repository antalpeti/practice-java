package lambda.example002;

/**
 * Functional interface for a two-step operation
 */
@FunctionalInterface
interface TwoStepOperation {

  int execute(int a, int b);
}
