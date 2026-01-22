package antalpeti.learn.generics.bounds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumericBoxTest {
	@Test
	void asDouble_usesNumberDoubleValue() {
		assertEquals(123.0, new NumericBox<>(123).asDouble(), 0.000_001);
		assertEquals(3.14, new NumericBox<>(3.14).asDouble(), 0.000_001);
	}
}
