package antalpeti.learn.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class MapExamplesTest {

  @Test
  void countOccurrencesShouldCountEachElementFrequency() {
    final var result = MapExamples.countOccurrences(
      List.of("apple", "banana", "apple", "orange", "apple", "banana")
    );

    assertEquals(3, result.get("apple"));
    assertEquals(2, result.get("banana"));
    assertEquals(1, result.get("orange"));
  }

  @Test
  void mergeSummingValuesShouldSumMatchingKeys() {
    final Map<String, Integer> left = new LinkedHashMap<>();
    left.put("apple", 3);
    left.put("banana", 2);

    final Map<String, Integer> right = new LinkedHashMap<>();
    right.put("banana", 5);
    right.put("orange", 1);

    final var result = MapExamples.mergeSummingValues(left, right);

    final Map<String, Integer> expected = new LinkedHashMap<>();
    expected.put("apple", 3);
    expected.put("banana", 7);
    expected.put("orange", 1);
    assertEquals(expected, result);
  }

  @Test
  void filterByMinimumValueShouldKeepOnlyEntriesAtLeastThreshold() {
    final Map<String, Integer> source = new LinkedHashMap<>();
    source.put("apple", 3);
    source.put("banana", 2);
    source.put("orange", 5);
    source.put("pear", 1);

    final var result = MapExamples.filterByMinimumValue(source, 3);

    final Map<String, Integer> expected = new LinkedHashMap<>();
    expected.put("apple", 3);
    expected.put("orange", 5);
    assertEquals(expected, result);
  }

  @Test
  void keysSortedByValueDescendingShouldSortByValueThenByKey() {
    final Map<String, Integer> source = new LinkedHashMap<>();
    source.put("orange", 2);
    source.put("banana", 4);
    source.put("apple", 4);
    source.put("pear", 1);

    final var result = MapExamples.keysSortedByValueDescending(source);

    assertEquals(List.of("apple", "banana", "orange", "pear"), result);
  }
}
