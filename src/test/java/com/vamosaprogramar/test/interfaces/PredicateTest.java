package com.vamosaprogramar.test.interfaces;

import static org.junit.Assert.*;

import java.util.function.Predicate;

import org.junit.Test;

public class PredicateTest {

	/**********************************************************
	 * Predicate Interface [Testing]
	 * 
	 *********************************************************/

	@Test
	public void simplePredicateUsingTest_thenTrue() {

		String string = "Naren";

		Predicate<String> lengthGreaterThanFour = x -> x.length() > 4;

		boolean actual = lengthGreaterThanFour.test(string);

		assertTrue(actual);

	}

	@Test
	public void simplePredicateUsingTest_thenFalse() {

		String string = "Nar";

		Predicate<String> lengthGreaterThanFour = x -> x.length() > 4;

		boolean actual = lengthGreaterThanFour.test(string);

		assertFalse(actual);

	}

	@Test
	public void predicateChainingUsingAnd_thenTrue() {

		String string = "DeAvila";

		Predicate<String> lengthGreaterThanFour = x -> x.length() > 4;

		Predicate<String> lengthLowerThanEight = x -> x.length() < 8;

		boolean actual = lengthGreaterThanFour.and(lengthLowerThanEight).test(string);

		assertTrue(actual);
	}

	@Test
	public void predicateChainingUsingAnd_thenFalse() {

		String string = "DeAvilaJulio";

		Predicate<String> lengthGreaterThanFour = x -> x.length() > 4;

		Predicate<String> lengthLowerThanEight = x -> x.length() < 8;

		boolean actual = lengthGreaterThanFour.and(lengthLowerThanEight).test(string);

		assertFalse(actual);
	}

	@Test
	public void negatePredicateUsingNegate_thenTrue() {
		String string = "Nar";

		Predicate<String> lengthGreaterThanFour = x -> x.length() > 4;

		boolean actual = lengthGreaterThanFour.negate().test(string);

		assertTrue(actual);
	}

	@Test
	public void negatePredicateUsingNegate_thenFalse() {
		String string = "Naren";

		Predicate<String> lengthGreaterThanFour = x -> x.length() > 4;

		boolean actual = lengthGreaterThanFour.negate().test(string);

		assertFalse(actual);
	}

	@Test
	public void predicateChainingUsingOr_thenTrue() {

		String string = "Naren is hungry";

		Predicate<String> containsHello = x -> x.contains("Hello");

		Predicate<String> startsWithN = x -> x.startsWith("N");

		boolean actual = containsHello.or(startsWithN).test(string);

		assertTrue(actual);

	}

	@Test
	public void predicateChainingUsingOr_thenFalse() {

		String string = "David is hungry";

		Predicate<String> containsHello = x -> x.contains("Hello");

		Predicate<String> startsWithN = x -> x.startsWith("N");

		boolean actual = containsHello.or(startsWithN).test(string);

		assertFalse(actual);

	}

	@Test
	public void retrivingPredicateUsingIsEqual_theTrue() {

		Predicate<String> predicate = Predicate.isEqual("Naren");

		boolean actual = predicate.test("Naren");

		assertTrue(actual);
	}

	@Test
	public void retrivingPredicateUsingIsEqual_thenFalse() {

		Predicate<String> predicate = Predicate.isEqual("Naren");

		boolean actual = predicate.test("David");

		assertFalse(actual);
	}
	

	
	

}
