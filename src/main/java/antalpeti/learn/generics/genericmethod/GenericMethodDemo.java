package antalpeti.learn.generics.genericmethod;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Demonstrates generic methods on different element types.
 */
@Slf4j
public final class GenericMethodDemo {
	private GenericMethodDemo() {
	}

	public static void run() {
		log.info("== Generic method demo ==");

		Integer[] ints = {1, 2, 3};
		String[] strings = {"a", "b", "c"};

		GenericMethods.printArray(ints);
		GenericMethods.printArray(strings);

		log.info("first of ints: {}", GenericMethods.first(List.of(10, 20, 30)));
		log.info("first of strings: {}", GenericMethods.first(List.of("x", "y")));
	}
}
