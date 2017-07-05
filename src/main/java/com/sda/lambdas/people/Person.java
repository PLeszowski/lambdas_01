package com.sda.lambdas.people;

/**
 * Created by RENT on 2017-07-04.
 */
public class Person {

	private int id;
	private String name;
	private String gender;
	private int age;
	private String job;

	public Person(int id, String name, String gender, int age, String job) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.job = job;
	}

	public String toString(){

		return this.name + ", " + super.toString();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	public String getJob() {
		return job;
	}
}
