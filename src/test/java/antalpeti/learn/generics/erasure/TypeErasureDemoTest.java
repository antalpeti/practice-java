package antalpeti.learn.generics.erasure;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TypeErasureDemoTest {
	@Test
	void parameterizedListsHaveSameRuntimeClass() {
		List<String> strings = new ArrayList<>(); // NOSONAR java:S2133
		List<Integer> integers = new ArrayList<>(); // NOSONAR java:S2133
		assertSame(strings.getClass(), integers.getClass());
	}
}
