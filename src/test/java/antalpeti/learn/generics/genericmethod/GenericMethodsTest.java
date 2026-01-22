package antalpeti.learn.generics.genericmethod;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenericMethodsTest {
	@Test
	void first_returnsFirstElement() {
		assertEquals("a", GenericMethods.first(List.of("a", "b")));
		assertEquals(10, GenericMethods.first(List.of(10, 20)));
	}

	@Test
	void first_throwsOnEmpty() {
			List<Object> empty = List.of();
			assertThrows(IllegalArgumentException.class, () -> GenericMethods.first(empty));
	}
}
