package lambda.example001;

import java.util.function.IntUnaryOperator;

/**
 * Custom functional interface for integer operations that returns a function
 */
@FunctionalInterface
interface IntegerOperationComposer {

  IntUnaryOperator apply(int a, int b);
}
