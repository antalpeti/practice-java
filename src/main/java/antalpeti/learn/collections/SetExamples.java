package antalpeti.learn.collections;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public final class SetExamples {

  private SetExamples() {
  }

  public static Set<String> toUniquePreservingOrder(final Collection<String> source) {
    return new LinkedHashSet<>(source);
  }

  public static Set<String> union(final Collection<String> left, final Collection<String> right) {
    final var result = new LinkedHashSet<>(left);
    result.addAll(right);
    return result;
  }

  public static Set<String> intersection(final Collection<String> left, final Collection<String> right) {
    final var result = new LinkedHashSet<>(left);
    result.retainAll(new LinkedHashSet<>(right));
    return result;
  }

  public static Set<String> difference(final Collection<String> left, final Collection<String> right) {
    final var result = new LinkedHashSet<>(left);
    result.removeAll(new LinkedHashSet<>(right));
    return result;
  }

  public static boolean isSubset(final Collection<String> subset, final Collection<String> superset) {
    return new LinkedHashSet<>(superset).containsAll(subset);
  }
}
