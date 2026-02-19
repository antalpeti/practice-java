package lambda.example001;

/**
 * Custom functional interface for three-integer operations
 */
@FunctionalInterface
interface ThreeIntegerOperation {

  int apply(int a, int b, int c);
}
