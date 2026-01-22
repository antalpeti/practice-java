package antalpeti.learn.generics.multiplebounds;

/**
 * Multiple bounds examples:
 * - class + interfaces or multiple interfaces
 * - typical pattern: T extends Number & Comparable<T>
 */
public final class MultipleBoundsUtil {
	private MultipleBoundsUtil() {
	}

	public static <T extends Number & Comparable<T>> T max(T a, T b) {
		return a.compareTo(b) >= 0 ? a : b;
	}

	public static <T extends Identifiable & Timestamped> String describe(T obj) {
		return "id=" + obj.id() + ", timestamp=" + obj.timestamp();
	}
}
