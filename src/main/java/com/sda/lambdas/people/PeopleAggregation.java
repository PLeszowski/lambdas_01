package com.sda.lambdas.people;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

/**
 * Created by RENT on 2017-07-04.
 */
public class PeopleAggregation {

	OptionalDouble getAverageAge(List<Person> people){

		return people.stream().map(Person::getAge).mapToDouble(Integer::doubleValue).average();

	}

	long getTotalWomen(List<Person> people) {

		return people.stream().filter(person -> person.getGender().equals("female")).count();

	}

	long getTotalMen(List<Person> people) {

		return people.stream().filter(person -> person.getGender().equals("male")).count();
	}

	Person getTheYoungestPerson(List<Person> people){

		//return  people.stream().sorted(new AgeComparator()).findFirst().get();

		return people.stream().min(new AgeComparator()).get();
	}

	Person getTheOldestPerson(List<Person> people){

		return people.stream().max(new AgeComparator()).get();
	}
}

class AgeComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		return Integer.compare(o1.getAge(), o2.getAge());
	}
}
