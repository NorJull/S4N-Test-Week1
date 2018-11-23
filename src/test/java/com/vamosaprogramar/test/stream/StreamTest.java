package com.vamosaprogramar.test.stream;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

import com.vamosaprogramar.entity.Person;
import com.vamosaprogramar.entity.Pet;

public class StreamTest {

	/**********************************************************
	 * Creating Streams [Testing]
	 * 
	 *********************************************************/

	@Test
	public void toCreateStreamWithStream() {

		List<String> list = Arrays.asList("Naren", "David", "De Avila", "Julio");

		List<String> actual = list.stream().map(String::toUpperCase).collect(Collectors.toList());

		assertEquals(Arrays.asList("NAREN", "DAVID", "DE AVILA", "JULIO"), actual);
	}

	@Test
	public void toCreateStreamWithOf() {

		List<String> actual = Stream.of("Naren", "David", "De Avila", "Julio").map(String::toUpperCase)
				.collect(Collectors.toList());

		assertEquals(Arrays.asList("NAREN", "DAVID", "DE AVILA", "JULIO"), actual);
	}

	/**********************************************************
	 * Transforming a regular object stream to a primitive 
	 * stream [Testing]
	 * 
	 *********************************************************/

	@Test
	public void toTransformStreamWithMapToInt() {

		Integer actual = Stream.of("S4N", "S5N", "S6N").map(x -> x.substring(1, 2)).mapToInt(x -> Integer.parseInt(x))
				.min().orElse(5);

		assertEquals(4, actual, 0.0);

	}

	@Test
	public void toTransformIntStreamWithMapToObj() {

		List<String> actual = IntStream.of(4, 5, 6).mapToObj(x -> "S" + x + "N").collect(Collectors.toList());

		assertEquals(Arrays.asList("S4N", "S5N", "S6N"), actual);

	}

	/**********************************************************
	 * Filtering [Testing]
	 * 
	 *********************************************************/

	@Test
	public void toFilterStreamWithFilter() {

		List<String> actual = Stream.of("S4N", "S5N", "S6N").filter(x -> x.substring(1, 2).equals("4"))
				.collect(Collectors.toList());

		assertEquals(Arrays.asList("S4N"), actual);
	}

	@Test
	public void toFilterStreamWithFilterAndMap() {

		List<String> actual = Stream.of("s4n", "s5n", "s6n").filter(x -> x.substring(1, 2).equals("4"))
				.map(String::toUpperCase).collect(Collectors.toList());

		assertEquals(Arrays.asList("S4N"), actual);
	}

	/**********************************************************
	 * Sorting [Testing]
	 * 
	 *********************************************************/

	@Test
	public void toSortStreamWithSorted() {

		List<String> actual = Stream.of("aaaa", "aa", "aaaa", "aaa", "a").map(String::toUpperCase)
				.sorted((x, y) -> x.length() > y.length() ? 1 : -1).collect(Collectors.toList());

		assertEquals(Arrays.asList("A", "AA", "AAA", "AAAA", "AAAA"), actual);
	}

	/**********************************************************
	 * Reusing Streams [Testing]
	 * 
	 *********************************************************/

	@Test(expected = IllegalStateException.class)
	public void toReusingStreams_thenThrowExecption() {
		Stream stream = Stream.of("Naren", "David", "De Avila", "Julio");

		boolean actual = stream.anyMatch(x -> x.equals("Julio"));

		assertTrue(actual);

		actual = stream.noneMatch(x -> x.equals("Jesus"));
	}

	@Test
	public void toReusingStreams_thenCorrect() {
		Supplier<Stream<String>> supplierStream = () -> Stream.of("Naren", "David", "De Avila", "Julio");

		boolean actual = supplierStream.get().anyMatch(x -> x.equals("Julio"));

		assertTrue(actual);

		actual = supplierStream.get().noneMatch(x -> x.equals("Jesus"));

		assertTrue(actual);
	}

	/**********************************************************
	 * Collect Streams [Testing]
	 * 
	 *********************************************************/

	@Test
	public void collectStreamUsingCollectorsJoining01() {

		String actual = Arrays.asList("a", "b", "c", "d").stream().collect(Collectors.joining(","));

		assertEquals("a,b,c,d", actual);

	}

	@Test
	public void collectStreamUsingCollectorsJoining02() {

		String actual = Arrays.asList("a", "b", "c", "d").stream()
				.collect(Collectors.joining(",", "First 4 letters of the alphabet ", ""));

		assertEquals("First 4 letters of the alphabet a,b,c,d", actual);

	}

	@Test
	public void collectStreamUsingCollectorsJoining03() {

		String actual = Arrays.asList("a", "b", "c", "d").stream()
				.collect(Collectors.joining(",", "First 4 letters of the alphabet ", " and the fifth f"));

		assertEquals("First 4 letters of the alphabet a,b,c,d and the fifth f", actual);

	}

	@Test
	public void collectStreamUsingCollectorsAveragingDouble() {

		List<Person> persons = new ArrayList<Person>();

		persons.add(new Person("Naren", 23));
		persons.add(new Person("David", 24));
		persons.add(new Person("Julio", 25));

		double actual = persons.stream().collect(Collectors.averagingDouble(x -> x.getAge().orElse(0)));

		assertEquals(24, actual, 0.0);
	}

	/**********************************************************
	 * FlatMap Streams [Testing]
	 * 
	 *********************************************************/

	@Test
	public void flatMapStream() {

		List<Person> persons = new ArrayList<>();

		IntStream.range(1, 3).forEach(x -> persons.add(new Person("Person #" + x, x)));

		persons.forEach(p -> IntStream.range(1, 3)
				.forEach(x -> p.getPets().get().add(new Pet("Pet #" + x + "<-" + p.getName().get()))));

		List<String> actual = persons.stream().flatMap(x -> x.getPets().get().stream()).map(y -> y.getName().get())
				.collect(Collectors.toList());

		assertEquals(Arrays.asList("Pet #1<-Person #1", "Pet #2<-Person #1", "Pet #1<-Person #2", "Pet #2<-Person #2"),
				actual);

	}

	/**********************************************************
	 * Reduce Streams [Testing]
	 * 
	 *********************************************************/

	@Test
	public void reduceStream() {

		List<Person> persons = new ArrayList<>();

		IntStream.range(1, 3).forEach(x -> persons.add(new Person("Person #" + x, x)));

		Integer actual = persons.stream().reduce(0, (sum, p) -> sum += p.getAge().orElse(0),
				(sum1, sum2) -> sum1 + sum2);

		assertEquals(3, actual, 0.0);

	}

}
