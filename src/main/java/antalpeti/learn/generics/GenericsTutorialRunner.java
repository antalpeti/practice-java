package antalpeti.learn.generics;

import antalpeti.learn.generics.bounds.BoundedTypeParamsDemo;
import antalpeti.learn.generics.erasure.TypeErasureDemo;
import antalpeti.learn.generics.genericclass.GenericClassDemo;
import antalpeti.learn.generics.genericmethod.GenericMethodDemo;
import antalpeti.learn.generics.multiplebounds.MultipleBoundsDemo;
import antalpeti.learn.generics.wildcards.WildcardsDemo;

/**
 * A small runner that executes all generics examples in a deterministic order.
 */
public final class GenericsTutorialRunner {
	private GenericsTutorialRunner() {
	}

	public static void main(String[] args) {
		GenericClassDemo.run();
		GenericMethodDemo.run();
		BoundedTypeParamsDemo.run();
		WildcardsDemo.run();
		TypeErasureDemo.run();
		MultipleBoundsDemo.run();
	}
}
