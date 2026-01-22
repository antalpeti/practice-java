package antalpeti.learn.generics.wildcards;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WildcardExamplesTest {
	@Test
	void sum_worksForIntegers() {
		assertEquals(6.0, WildcardExamples.sum(List.of(1, 2, 3)), 0.000_001);
	}

	@Test
	void addIntegers_addsToNumberList() {
		List<Number> target = new ArrayList<>();
		WildcardExamples.addIntegers(target);
		assertEquals(List.of(1, 2, 3), target);
	}
}
