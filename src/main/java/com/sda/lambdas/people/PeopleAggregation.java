package com.sda.lambdas.people;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by RENT on 2017-07-04.
 */
public class PeopleAggregation {

	public OptionalDouble getAverageAge(List<Person> people){

		return people.stream().map(Person::getAge).mapToDouble(Integer::doubleValue).average();
	}

	public long getTotalWomen(List<Person> people) {

		return people.stream().filter(person -> person.getGender().equals("female")).count();
	}

	public long getTotalMen(List<Person> people) {

		return people.stream().filter(person -> person.getGender().equals("male")).count();
	}

	public Person getTheYoungestPerson(List<Person> people){

		return people.stream().min(new AgeComparator()).get();
	}

	public Person getTheOldestPerson(List<Person> people){

		return people.stream().max(new AgeComparator()).get();
	}

	public Map<Integer,Person> aggregateById(List<Person> people){

		return people.stream().collect(Collectors.toMap(Person::getId, Function.identity()));
		//return people.stream().collect(Collectors.toMap(person -> person.getId(), person -> person));
//        Map<Integer,Person> aggregatedById = new HashMap<>();
//
//        people.forEach(person -> aggregatedById.put(person.getId(),person));
//
////        for (Person person : people) {
////            aggregatedById.put(person.getId(), person);
////        }
//        return aggregatedById;
	}
}

class AgeComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		return Integer.compare(o1.getAge(), o2.getAge());
	}
}
