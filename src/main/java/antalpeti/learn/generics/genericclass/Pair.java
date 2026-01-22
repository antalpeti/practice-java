package antalpeti.learn.generics.genericclass;

import java.util.Objects;

/**
 * Generic type with two type parameters.
 */
public final class Pair<K, V> { // NOSONAR java:S6206
	private final K key;
	private final V value;

	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K key() {
		return key;
	}

	public V value() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Pair<?, ?> other)) return false;
		return Objects.equals(key, other.key) && Objects.equals(value, other.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(key, value);
	}

	@Override
	public String toString() {
		return "Pair{" + key + "=" + value + "}";
	}
}
