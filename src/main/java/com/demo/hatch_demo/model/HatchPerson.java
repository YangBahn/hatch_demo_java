package com.demo.hatch_demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HatchPerson {
	private long id;
	private String name;
	private int age;

	HatchPerson(long id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
}