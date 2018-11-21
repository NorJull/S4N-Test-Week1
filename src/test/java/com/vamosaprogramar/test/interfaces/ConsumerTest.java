package com.vamosaprogramar.test.interfaces;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

public class ConsumerTest {

	/**********************************************************
	 * Consumer Interface [Testing]
	 * 
	 *********************************************************/

	@Test
	public void simpleConsumerUsingAccept() {
		List<String> list = Arrays.asList("Naren", "David", "De Avila", "Julio");

		Consumer<List<String>> consumer = x -> {
			for (int i = 0; i < x.size(); i++)
				x.set(i, x.get(i).toUpperCase());
		};

		consumer.accept(list);

		assertEquals(Arrays.asList("NAREN", "DAVID", "DE AVILA", "JULIO"), list);
	}

	@Test
	public void composedConsumerUsingAndThen() {
		List<String> list = Arrays.asList("Naren", "David", "De Avila", "Julio");

		Consumer<List<String>> consumerToUpperList = x -> {
			for (int i = 0; i < x.size(); i++)
				x.set(i, x.get(i).toUpperCase());
		};

		Consumer<List<String>> consumerToLowerList = x -> {
			for (int i = 0; i < x.size(); i++)
				x.set(i, x.get(i).toLowerCase());
		};

		consumerToUpperList.andThen(consumerToLowerList).accept(list);

		assertEquals(Arrays.asList("naren", "david", "de avila", "julio"), list);
	}

}
