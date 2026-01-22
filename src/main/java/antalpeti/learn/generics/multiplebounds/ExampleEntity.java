package antalpeti.learn.generics.multiplebounds;

import java.time.Instant;

public final class ExampleEntity implements Identifiable, Timestamped { // NOSONAR java:S6206
	private final String id;
	private final Instant timestamp;

	public ExampleEntity(String id, Instant timestamp) {
		this.id = id;
		this.timestamp = timestamp;
	}

	@Override
	public String id() {
		return id;
	}

	@Override
	public Instant timestamp() {
		return timestamp;
	}
}
