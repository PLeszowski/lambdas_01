package com.sda.lambdas.currency;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String[] args) throws IOException {

        //Wczytaj plik
        List<String> lines = Files.readAllLines(Paths.get("currency.csv"));

        //Podejscie funkcyjne
        List<Currency> currencies = lines.stream()
                .map(line -> line.split(","))
				.map(array -> new Currency(array[0], new BigDecimal(array[1])))
				.collect(Collectors.toList());
        currencies.forEach(System.out::println);



        //Podejscie klasyczne
        System.out.println("*********************Another way to display**********************");
        List<Currency> currencyList = new ArrayList<>();
        for(String line : lines){
            String[] array = line.split(",");
            String currencyName = array[0];
            String currencyValue = array[1];
            Currency currency = new Currency(currencyName,new BigDecimal(currencyValue));
            currencyList.add(currency);
        }

        for(Currency currency:currencyList){
            System.out.println(currency);
        }
    }
}
