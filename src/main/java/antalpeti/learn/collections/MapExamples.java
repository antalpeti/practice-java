package antalpeti.learn.collections;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class MapExamples {

  private MapExamples() {
  }

  public static Map<String, Integer> countOccurrences(final Collection<String> source) {
    final Map<String, Integer> frequencies = new LinkedHashMap<>();
    for (final String item : source) {
      frequencies.merge(item, 1, Integer::sum);
    }
    return frequencies;
  }

  public static Map<String, Integer> mergeSummingValues(
    final Map<String, Integer> left,
    final Map<String, Integer> right
  ) {
    final Map<String, Integer> result = new LinkedHashMap<>(left);
    right.forEach((key, value) -> result.merge(key, value, Integer::sum));
    return result;
  }

  public static Map<String, Integer> filterByMinimumValue(
    final Map<String, Integer> source,
    final int minimumValue
  ) {
    final Map<String, Integer> result = new LinkedHashMap<>();
    source.forEach((key, value) -> {
      if (value >= minimumValue) {
        result.put(key, value);
      }
    });
    return result;
  }

  public static List<String> keysSortedByValueDescending(final Map<String, Integer> source) {
    return source.entrySet().stream()
      .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder())
        .thenComparing(Map.Entry.comparingByKey()))
      .map(Map.Entry::getKey)
      .toList();
  }
}
