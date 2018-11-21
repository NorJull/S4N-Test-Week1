package com.vamosaprogramar.test.interfaces;

import static org.junit.Assert.*;

import java.util.function.BiFunction;

import org.junit.Test;

public class BiFunctionTest {

	/**********************************************************
	 * BiFunction Interface [Testing]
	 * 
	 *********************************************************/

	@Test
	public void simpleBiFunctionUsingApply() {

		BiFunction<String, String, Integer> getLength = (x, y) -> x.length() + y.length();

		Integer actual = getLength.apply("Naren", "David");

		assertEquals(10, actual, 0.0);

	}

	@Test
	public void composedBiFunctionUsingAddThen() {

		BiFunction<String, String, Integer> getLength = (x, y) -> x.length() + y.length();

		Integer actual = getLength.andThen(x -> x * 10).apply("Naren", "David");

		assertEquals(100, actual, 0.0);
	}

	@Test(expected = NullPointerException.class)
	public void composedBiFunctionUsingAddThen_GivenNull() {

		BiFunction<String, String, Integer> getLength = (x, y) -> x.length() + y.length();

		BiFunction composedBiFunction = getLength.andThen(null);

	}

}
