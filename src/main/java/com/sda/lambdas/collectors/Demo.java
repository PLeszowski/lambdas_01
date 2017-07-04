package com.sda.lambdas.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {

    public static void main(String[] args) {


        Car toyota = new Car("Toyota", 5);
        Car opel = new Car("Opel", 3);
        Car peugeot = new Car("Peugeot", 5);
        Car mercedes = new Car("Mercedes", 1);
        Car ford = new Car("Ford", 3);

        List<Car> cars = Arrays.asList(toyota, opel, peugeot, mercedes, ford);
        Map<String, Car> carMap = cars.stream().collect(Collectors.toMap(car -> car.getName(), car -> car));
        carMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));


        Set<Integer> integerSet = Stream.of(1, 2, 3, 1, 5, 6, 2, 5).collect(Collectors.toSet());
        integerSet.forEach(System.out::println);

    }
}
