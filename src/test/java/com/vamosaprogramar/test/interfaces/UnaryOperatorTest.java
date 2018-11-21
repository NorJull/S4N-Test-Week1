package com.vamosaprogramar.test.interfaces;

import static org.junit.Assert.*;

import java.util.function.Function;
import java.util.function.UnaryOperator;

import org.junit.Test;

public class UnaryOperatorTest {

	/**********************************************************
	 * UnaryOperator Interface [Testing]
	 * 
	 *********************************************************/

	@Test
	public void simpleUnaryOperatorUsingApply() {

		UnaryOperator<Double> addTen = x -> x + 10;

		Double actual = addTen.apply(10.0);

		assertEquals(20.0, actual, 0.0);

	}

	@Test
	public void composedUnaryOperatorUsingAddThen() {

		UnaryOperator<Double> addTen = x -> x + 10;

		Double actual = addTen.andThen(x -> x * 10).apply(10.0);

		assertEquals(200.0, actual, 0.0);
	}

	@Test(expected = NullPointerException.class)
	public void composedUnaryOperatorUsingAddThen_GivenNull() {

		UnaryOperator<Double> addTen = x -> x + 10;

		Function composedFunction = addTen.andThen(null);
	}

	@Test
	public void composedUnaryOperatorUsingCompose() {

		UnaryOperator<Double> addTen = x -> x + 10;

		UnaryOperator<Double> multiplyByTen = x -> x * 10;

		Double actual = addTen.compose(multiplyByTen).apply(10.0);

		assertEquals(110.0, actual, 0.0);

	}

	@Test(expected = NullPointerException.class)
	public void composedUnaryOperatorUsingCompose_GivenNull() {

		UnaryOperator<Double> addTen = x -> x + 10;

		Function composedFunction = addTen.compose(null);

	}

}
