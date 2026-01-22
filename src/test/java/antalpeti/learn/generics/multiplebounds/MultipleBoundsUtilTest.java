package antalpeti.learn.generics.multiplebounds;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class MultipleBoundsUtilTest {
	@Test
	void max_returnsLargerComparableNumber() {
		assertEquals(20, MultipleBoundsUtil.max(10, 20));
		assertEquals(3.5, MultipleBoundsUtil.max(3.5, 2.1));
	}

	@Test
	void describe_usesBothBounds() {
		ExampleEntity e = new ExampleEntity("X", Instant.EPOCH);
		String desc = MultipleBoundsUtil.describe(e);
		assertTrue(desc.contains("id=X"));
		assertTrue(desc.contains("timestamp="));
	}
}
