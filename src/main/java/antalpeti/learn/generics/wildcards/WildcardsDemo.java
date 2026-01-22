package antalpeti.learn.generics.wildcards;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates wildcards and why invariant generic types require ? extends / ? super.
 */
@Slf4j
public final class WildcardsDemo {
	private WildcardsDemo() {
	}

	public static void run() {
		log.info("== Wildcards demo ==");

		List<Integer> ints = List.of(1, 2, 3);
		log.info("sum(ints) = {}", WildcardExamples.sum(ints));

		List<Number> nums = new ArrayList<>();
		WildcardExamples.addIntegers(nums);
		log.info("after addIntegers: {}", nums);

		// You can read from ? extends Number, but you can't safely add anything except null.
		List<? extends Number> producer = ints;
		Number n = producer.getFirst();
		log.info("read from producer: {}", n);
		// producer.add(4); // does not compile
	}
}
