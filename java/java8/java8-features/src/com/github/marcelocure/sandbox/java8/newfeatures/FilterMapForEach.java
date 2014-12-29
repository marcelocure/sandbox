package com.github.marcelocure.sandbox.java8.newfeatures;

import java.util.List;


public class FilterMapForEach {
    public static void main(String[] args) {
		List<Person> people = PeopleDAO.getPeople();
		
		System.out.println("Older than 26");
		people.stream().filter(person -> person.getAge() > 26).forEach(System.out::println);
		
		System.out.println("new year ... increase age");
		people.stream().map(person -> new Person(person.getId(), person.getName(), person.getAge()+1)).forEach(System.out::println);
		
		System.out.println("average age");
		System.out.println(people.stream().mapToInt(person -> person.getAge()).average());
	}
}