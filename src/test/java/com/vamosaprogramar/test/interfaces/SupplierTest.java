package com.vamosaprogramar.test.interfaces;

import static org.junit.Assert.*;

import java.util.function.Supplier;

import org.junit.Test;

public class SupplierTest {

	/**********************************************************
	 * Supplier Interface [Testing]
	 * 
	 *********************************************************/

	@Test
	public void simpleSupplierUsingGet_WithAString() {
		Supplier<String> supplier = () -> "Naren";

		String actual = supplier.get();

		assertEquals("Naren", actual);

	}

	@Test
	public void simpleSupplierUsingGet_WithAInteger() {
		Supplier<Integer> supplier = () -> Math.max(10, 20);

		Integer actual = supplier.get();

		assertEquals(20, actual, 0.0);

	}

}
