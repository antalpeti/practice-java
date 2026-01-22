package antalpeti.learn.generics.multiplebounds;

import lombok.extern.slf4j.Slf4j;

import java.time.Instant;

/**
 * Demonstrates multiple bounds: "&" combines required supertypes.
 */
@Slf4j
public final class MultipleBoundsDemo {
	private MultipleBoundsDemo() {
	}

	public static void run() {
		log.info("== Multiple bounds demo ==");

		Integer max = MultipleBoundsUtil.max(10, 20);
		log.info("max(10, 20) = {}", max);

		ExampleEntity entity = new ExampleEntity("ABC-123", Instant.EPOCH);
		log.info("describe(entity) = {}", MultipleBoundsUtil.describe(entity));
	}
}
