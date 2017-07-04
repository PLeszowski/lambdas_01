package com.sda.lambdas;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Demo {

    public static void main(String[] args) {

        Optional<String> message = Optional.ofNullable("message");
        message.ifPresent(msg -> System.out.println(msg));

        Integer length = message.map(String::length).orElse(-1);
        System.out.printf("length: " + length);


        List<Integer> list = IntStream.range(1, 101).boxed()
                .filter(j->j>55)
                .filter(i -> i % 3 == 1)
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        list.forEach(System.out::println);


    }
}
