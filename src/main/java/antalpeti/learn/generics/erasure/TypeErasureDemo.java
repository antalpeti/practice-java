package antalpeti.learn.generics.erasure;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates type erasure: type parameters exist at compile time, but (mostly) not at runtime.
 */
@Slf4j
public final class TypeErasureDemo {
	private TypeErasureDemo() {
	}

	public static void run() {
		log.info("== Type erasure demo ==");

		List<String> strings = new ArrayList<>();
		List<Integer> integers = new ArrayList<>(); // NOSONAR java:S2133

		log.info("strings.getClass() == integers.getClass(): {}", strings.getClass() == integers.getClass());
		log.info("runtime class: {}", strings.getClass().getName());

		// instanceof with a parameterized type is illegal: // NOSONAR java:S125
		// if (strings instanceof List<String>) { } // does not compile // NOSONAR java:S125
	}
}
