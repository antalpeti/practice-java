package antalpeti.learn.generics.wildcards;

import java.util.List;

/**
 * Wildcard examples with the PECS rule:
 * - Producer Extends: read from ? extends
 * - Consumer Super: write to ? super
 */
public final class WildcardExamples {
	private WildcardExamples() {
	}

	public static double sum(List<? extends Number> numbers) {
		double total = 0.0;
		for (Number n : numbers) {
			total += n.doubleValue();
		}
		return total;
	}

	public static void addIntegers(List<? super Integer> sink) {
		sink.add(1);
		sink.add(2);
		sink.add(3);
	}
}
