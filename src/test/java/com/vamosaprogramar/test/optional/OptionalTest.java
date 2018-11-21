package com.vamosaprogramar.test.optional;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Test;

public class OptionalTest {

	/**********************************************************
	 * Creating Optional Object [Testing]
	 * 
	 *********************************************************/

	@Test
	public void toCreateAnEmptyOptional() {

		Optional<String> emptyOptional = Optional.empty();

		assertFalse(emptyOptional.isPresent());
	}

	@Test(expected = NoSuchElementException.class)
	public void toCreateAnEmptyOptional_AndReturningValue() {

		Optional<String> emptyOptional = Optional.empty();

		emptyOptional.get();
	}

	@Test
	public void toCreateAnOptionalWithOf() {

		String name = "Naren";

		Optional<String> optional = Optional.of(name);

		assertEquals("Naren", optional.get());
	}

	@Test(expected = NullPointerException.class)
	public void toCreateAnOptionalWithOf_GivenNull() {

		String name = null;

		Optional<String> optional = Optional.of(name);
	}

	@Test
	public void toCreateAnNullableOptional_GivenNoNull() {

		String name = "Naren";

		Optional<String> optional = Optional.ofNullable(name);

		assertEquals("Naren", optional.get());

	}

	@Test
	public void toCreateAnNullableOptional_GivenNull() {

		String name = null;

		Optional<String> optional = Optional.ofNullable(name);

		assertEquals("Optional.empty", optional.toString());

	}

	/**********************************************************
	 * isPresent() [Testing]
	 * 
	 *********************************************************/

	@Test
	public void checkingOptional_GivenNoNull() {

		String name = "Naren";

		Optional<String> optional = Optional.of(name);

		assertTrue(optional.isPresent());

	}

	@Test
	public void checkingOptional_GivenNull() {

		String name = null;

		Optional<String> optional = Optional.ofNullable(name);

		assertFalse(optional.isPresent());

	}

	/**********************************************************
	 * orElse() [Testing]
	 * 
	 *********************************************************/

	@Test
	public void retrivingWithOrElse_GivenNoNull() {

		Optional<String> optional = Optional.of("Naren");

		String actual = optional.orElse("David");

		assertEquals("Naren", actual);

	}

	@Test
	public void retrivingWithOrElse_GivenNull() {

		Optional<String> optional = Optional.ofNullable(null);

		String actual = optional.orElse("David");

		assertEquals("David", actual);

	}

	/**********************************************************
	 * orElseGet() [Testing]
	 * 
	 *********************************************************/

	@Test
	public void retrivingWithOrElseGet_GivinNoNull() {

		Optional<String> optional = Optional.ofNullable("Naren");

		String actual = optional.orElseGet(() -> "David");

		assertEquals("Naren", actual);

	}

	@Test
	public void retrivingWithOrElseGet_GivinNull() {

		Optional<String> optional = Optional.ofNullable(null);

		String actual = optional.orElseGet(() -> "David");

		assertEquals("David", actual);

	}

	/**********************************************************
	 * orElseThrow() [Testing]
	 * 
	 *********************************************************/

	@Test
	public void retrivingWithOrElseThrow_GivinNoNull() {

		Optional<Integer> optional = Optional.ofNullable(10);

		Integer actual = optional.orElseThrow(NumberFormatException::new);

		assertEquals(10, actual, 0.0);

	}

	@Test(expected = NumberFormatException.class)
	public void retrivingWithOrElseThrow_GivinNull() {

		Optional<Integer> optional = Optional.ofNullable(null);

		Integer actual = optional.orElseThrow(NumberFormatException::new);

		assertEquals(10, actual, 0.0);

	}

	/**********************************************************
	 * filer() [Testing]
	 * 
	 *********************************************************/

	@Test
	public void rejectingOptionalWithFilter_PassingTesting() {

		Optional<String> optional = Optional.ofNullable("NarenDavid").filter(x -> x.length() % 2 == 0);

		assertEquals("Optional[NarenDavid]", optional.toString());

	}

	@Test
	public void rejectingOptionalWithFilter_FallingTesting() {

		Optional<String> optional = Optional.ofNullable("Naren").filter(x -> x.length() % 2 == 0);

		assertEquals("Optional.empty", optional.toString());

	}

	/**********************************************************
	 * map() [Testing]
	 * 
	 *********************************************************/

	@Test
	public void transformingOptionalWithMap() {

		Optional<String> optional = Optional.ofNullable("Naren");

		String actual = optional.map(x -> x.toUpperCase()).orElse("Naren");

		assertEquals("NAREN", actual);

	}

}
