package antalpeti.learn.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class SetExamplesTest {

  @Test
  void toUniquePreservingOrderShouldRemoveDuplicates() {
    final var result = SetExamples.toUniquePreservingOrder(
      List.of("apple", "banana", "apple", "orange", "banana")
    );

    assertEquals(Set.of("apple", "banana", "orange"), result);
    assertEquals(List.of("apple", "banana", "orange"), List.copyOf(result));
  }

  @Test
  void unionShouldContainAllElementsWithoutDuplicates() {
    final var result = SetExamples.union(
      List.of("apple", "banana", "orange"),
      List.of("banana", "pear")
    );

    assertEquals(List.of("apple", "banana", "orange", "pear"), List.copyOf(result));
  }

  @Test
  void intersectionShouldContainOnlyCommonElements() {
    final var result = SetExamples.intersection(
      List.of("apple", "banana", "orange"),
      List.of("banana", "pear", "orange")
    );

    assertEquals(List.of("banana", "orange"), List.copyOf(result));
  }

  @Test
  void differenceShouldContainElementsOnlyFromLeftCollection() {
    final var result = SetExamples.difference(
      List.of("apple", "banana", "orange"),
      List.of("banana", "pear")
    );

    assertEquals(List.of("apple", "orange"), List.copyOf(result));
  }

  @Test
  void isSubsetShouldReturnTrueOnlyForValidSubset() {
    assertTrue(SetExamples.isSubset(
      List.of("banana", "orange"),
      List.of("apple", "banana", "orange")
    ));

    assertFalse(SetExamples.isSubset(
      List.of("banana", "pear"),
      List.of("apple", "banana", "orange")
    ));
  }
}
