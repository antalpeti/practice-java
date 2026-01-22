package antalpeti.learn.generics.bounds;

import lombok.extern.slf4j.Slf4j;

/**
 * Demonstrates bounded type parameters: "extends" restricts what types can be used.
 */
@Slf4j
public final class BoundedTypeParamsDemo {
	private BoundedTypeParamsDemo() {
	}

	public static void run() {
		log.info("== Bounded type parameters demo ==");

		NumericBox<Integer> intBox = new NumericBox<>(123);
		NumericBox<Double> dblBox = new NumericBox<>(3.14);

		log.info("intBox as double: {}", intBox.asDouble());
		log.info("dblBox as double: {}", dblBox.asDouble());

		// NumericBox<String> no = new NumericBox<>("nope"); // does not compile
	}
}
