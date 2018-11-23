package com.vamosaprogramar.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Person {

	private String name;

	private int age;

	private List<Pet> pets;

	public Person() {

		this.pets = new ArrayList<Pet>();
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		this.pets = new ArrayList<Pet>();
	}

	public Person(String name, int age, List<Pet> pets) {
		this.name = name;
		this.age = age;
		this.pets = pets;
	}

	public Optional<List<Pet>> getPets() {
		return Optional.ofNullable(pets);
	}

	public Optional<String> getName() {
		return Optional.ofNullable(name);
	}

	public Optional<Integer> getAge() {
		return Optional.ofNullable(age);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

}
