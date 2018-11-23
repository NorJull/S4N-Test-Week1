package com.vamosaprogramar.entity;

import java.util.Optional;

public class Pet {

	private String name;

	public Pet() {

	}

	public Pet(String name) {
		this.name = name;
	}

	public Optional<String> getName() {
		return Optional.ofNullable(name);
	}

	public void setName(String name) {
		this.name = name;
	}

}
