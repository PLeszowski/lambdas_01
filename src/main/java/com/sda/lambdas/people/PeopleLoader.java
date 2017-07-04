package com.sda.lambdas.people;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by RENT on 2017-07-04.
 */
public class PeopleLoader {

	List<Person> loadPeopleFromFile(String pathFile) throws IOException {

		List<String> lines = Files.readAllLines(Paths.get(pathFile));

		List<Person> people = lines.stream()
						.map(line -> line.split(","))
						.map(array -> new Person(Integer.parseInt(array[0]), array[1], array[2], Integer.parseInt(array[3]), array[4]))
						.collect(Collectors.toList());


		return people;
	}
}
