package com.java8.sample;


import java.util.Arrays;
import java.util.List;


public class SampleStreams {

    public static void main(String[] args) {

        List<Country> countries = Arrays.asList(
                new Country("Argentina"),
                new Country("Australia"),
                new Country("Brazil"),
                new Country("Canada"),
                new Country("Switzerland"));

        countries
                .stream()
                .filter(country -> country.getName().startsWith("A"))
                .map(country -> country.getName())
                .forEach(System.out::println);
    }

}

class Country {
    private String name;

    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
