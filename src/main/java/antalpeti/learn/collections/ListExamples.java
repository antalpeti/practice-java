package antalpeti.learn.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class ListExamples {

  private ListExamples() {
  }

  public static List<String> addAndInsert(
    final Collection<String> source,
    final String appendItem,
    final int insertIndex,
    final String insertItem
  ) {
    final var result = new ArrayList<>(source);
    result.add(appendItem);
    result.add(insertIndex, insertItem);
    return result;
  }

  public static List<Integer> sortedAscending(final Collection<Integer> source) {
    return source.stream()
      .sorted()
      .toList();
  }

  public static List<Integer> sortedDescending(final Collection<Integer> source) {
    return source.stream()
      .sorted(Comparator.reverseOrder())
      .toList();
  }

  public static List<String> distinctKeepingOrder(final Collection<String> source) {
    return source.stream()
      .distinct()
      .toList();
  }

  public static Map<Boolean, List<Integer>> partitionEvenOdd(final Collection<Integer> source) {
    return source.stream()
      .collect(Collectors.partitioningBy(number -> number % 2 == 0));
  }
}
