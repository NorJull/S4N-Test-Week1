package com.vamosaprogramar.test.interfaces;

import static org.junit.Assert.*;

import java.util.function.Function;

import org.junit.Test;

public class FunctionTest {

	/**********************************************************
	 * Function Interface [Testing]
	 * 
	 *********************************************************/

	@Test
	public void simpleFunctionUsingApply() {

		Function<String, String> concatFour = x -> x.concat("4");

		String actual = concatFour.apply("S");

		assertEquals("S4", actual);
	}

	@Test
	public void composedFunctionUsingAddThen() {

		Function<String, String> concatFour = x -> x.concat("4");

		String actual = concatFour.andThen(x -> x.concat("N")).apply("S");

		assertEquals("S4N", actual);

	}

	@Test(expected = NullPointerException.class)
	public void composedFunctionUsingAddThen_GivenNull() {

		Function<String, String> concatFour = x -> x.concat("4");

		Function composedFunction = concatFour.andThen(null);

	}

	@Test
	public void composedFunctionUsingCompose() {

		Function<String, String> concatFour = x -> x.concat("4");

		Function<String, String> concatN = x -> x.concat("N");

		String actual = concatFour.compose(concatN).apply("S");

		assertEquals("SN4", actual);

	}

	@Test(expected = NullPointerException.class)
	public void composedFunctionUsingCompose_GivenNull() {

		Function<String, String> concatFour = x -> x.concat("4");

		Function composedFunction = concatFour.compose(null);

	}

}
