package antalpeti.learn.generics.genericclass;

import lombok.extern.slf4j.Slf4j;

/**
 * Demonstrates how generic classes provide type safety without casts.
 */
@Slf4j
public final class GenericClassDemo {
	private GenericClassDemo() {
	}

	public static void run() {
		log.info("== Generic class demo ==");

		Box<Integer> intBox = new Box<>(42);
		Integer i = intBox.get();
		log.info("intBox holds: {}", i);

		Box<String> strBox = new Box<>("hello");
		String s = strBox.get();
		log.info("strBox holds: {}", s);

		Pair<String, Integer> pair = new Pair<>("age", 30);
		log.info("pair: {}, key={}, value={}", pair, pair.key(), pair.value());

		// Raw types exist for backward compatibility, but they remove type safety.
		// Box raw = new Box("oops"); // Avoid: causes unchecked warnings.
	}
}
