package antalpeti.learn.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class ListExamplesTest {

  @Test
  void addAndInsertShouldAppendAndInsertItems() {
    final var result = ListExamples.addAndInsert(
      List.of("apple", "banana"),
      "orange",
      1,
      "pear"
    );

    assertEquals(List.of("apple", "pear", "banana", "orange"), result);
  }

  @Test
  void sortedAscendingShouldOrderNumbersFromSmallestToLargest() {
    final var result = ListExamples.sortedAscending(List.of(8, 2, 4, 1, 2));

    assertEquals(List.of(1, 2, 2, 4, 8), result);
  }

  @Test
  void sortedDescendingShouldOrderNumbersFromLargestToSmallest() {
    final var result = ListExamples.sortedDescending(List.of(8, 2, 4, 1, 2));

    assertEquals(List.of(8, 4, 2, 2, 1), result);
  }

  @Test
  void distinctKeepingOrderShouldKeepFirstAppearanceOrder() {
    final var result = ListExamples.distinctKeepingOrder(
      List.of("cat", "dog", "cat", "bird", "dog")
    );

    assertEquals(List.of("cat", "dog", "bird"), result);
  }

  @Test
  void partitionEvenOddShouldSplitNumbersIntoTwoGroups() {
    final var result = ListExamples.partitionEvenOdd(List.of(1, 2, 3, 4, 5, 6));

    assertEquals(List.of(2, 4, 6), result.get(true));
    assertEquals(List.of(1, 3, 5), result.get(false));
  }
}
