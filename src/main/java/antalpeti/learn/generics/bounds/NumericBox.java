package antalpeti.learn.generics.bounds;

/**
 * Bounded type parameter example: T must be a Number.
 */
public final class NumericBox<T extends Number> {
	private final T value;

	public NumericBox(T value) {
		this.value = value;
	}

	public T get() {
		return value;
	}

	public double asDouble() {
		return value.doubleValue();
	}
}
