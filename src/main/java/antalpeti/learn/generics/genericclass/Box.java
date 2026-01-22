package antalpeti.learn.generics.genericclass;

/**
 * Basic generic type example: the same class works for different types (compile-time safe).
 */
public final class Box<T> {
	private final T value;

	public Box(T value) {
		this.value = value;
	}

	public T get() {
		return value;
	}
}
