package com.vamosaprogramar.test.interfaces;

import static org.junit.Assert.*;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

import org.junit.Test;

public class BinaryOperatorTest {

	/**********************************************************
	 * BinaryOperator Interface [Testing]
	 * 
	 *********************************************************/

	@Test
	public void simpleBinaryOperatorUsingMaxBy() {

		BinaryOperator<Integer> max = BinaryOperator.maxBy((x, y) -> x.compareTo(y));

		Integer actual = max.apply(23, 92);

		assertEquals(92, actual, 0.0);
	}

	@Test
	public void simpleBinaryOperatorUsingMinBy() {

		BinaryOperator<Integer> max = BinaryOperator.minBy((x, y) -> x.compareTo(y));

		Integer actual = max.apply(23, 92);

		assertEquals(23, actual, 0.0);
	}

	@Test
	public void simpleBinaryOperatorUsingApply() {

		BinaryOperator<String> putTogether = (x, y) -> x.concat(y);

		String actual = putTogether.apply("Naren", "David");

		assertEquals("NarenDavid", actual);
	}

	@Test
	public void composedBinaryOperatorUsingAddThen() {

		BinaryOperator<String> putTogether = (x, y) -> x.concat(y);

		String actual = putTogether.andThen(x -> x.concat("De Avila")).apply("Naren", "David");

		assertEquals("NarenDavidDe Avila", actual);
	}

	@Test(expected = NullPointerException.class)
	public void composedBinaryOperatorUsingAddThen_GivenNull() {

		BinaryOperator<String> putTogether = (x, y) -> x.concat(y);

		BiFunction composedBinaryOperator = putTogether.andThen(null);
	}

}
