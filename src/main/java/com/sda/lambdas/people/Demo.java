package com.sda.lambdas.people;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by RENT on 2017-07-04.
 */
public class Demo {

	public static void main(String[] args) throws IOException {

		List<Person> people = new PeopleLoader().loadPeopleFromFile("people.csv");

		people.stream().forEach(person -> System.out.println(person.getName()));

		PeopleAggregation peopleAggregation = new PeopleAggregation();
		printSeperator();
		System.out.println("Total women: " + peopleAggregation.getTotalWomen(people));
		printSeperator();
		System.out.println("Total men: " + peopleAggregation.getTotalMen(people));
		printSeperator();
		System.out.println("Youngest person : " + peopleAggregation.getTheYoungestPerson(people).getName());
		printSeperator();
		System.out.println("Oldest person : " + peopleAggregation.getTheOldestPerson(people).getName());
		printSeperator();
		//System.out.println(peopleAggregation.aggregateById(people));
		peopleAggregation.aggregateById(people).forEach((k,v) -> System.out.println("Key: " + k + ", value: " + v));
//        Map<Integer,Person> aggregatedById = new HashMap<>();
//        aggregatedById = peopleAggregation.aggregateById(people);
//        aggregatedById.forEach((k,v) -> System.out.println("Key: " + k + ", value: " + v));

	}

	public static void printSeperator(){
		System.out.println("-------------------");
	}
}
