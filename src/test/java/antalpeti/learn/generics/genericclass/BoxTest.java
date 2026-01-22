package antalpeti.learn.generics.genericclass;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoxTest {
	@Test
	void storesAndReturnsSameType() {
		Box<String> box = new Box<>("hello");
		assertEquals("hello", box.get());
	}
}
