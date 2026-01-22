package antalpeti.learn.generics.genericmethod;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Examples of generic methods: the method, not the class, declares type parameters.
 */
@Slf4j
public final class GenericMethods {
	private GenericMethods() {
	}

	public static <T> void printArray(T[] items) {
		StringBuilder sb = new StringBuilder();
		for (T item : items) {
			if (!sb.isEmpty()) {
				sb.append(' ');
			}
			sb.append(item);
		}
		log.info("{}", sb);
	}

	public static <T> T first(List<T> list) {
		if (list == null || list.isEmpty()) {
			throw new IllegalArgumentException("list must not be null/empty");
		}
		return list.getFirst();
	}
}
