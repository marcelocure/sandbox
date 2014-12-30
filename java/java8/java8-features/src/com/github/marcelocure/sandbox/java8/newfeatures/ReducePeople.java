package com.github.marcelocure.sandbox.java8.newfeatures;

import java.util.List;


public class ReducePeople {
    public static void main(String[] args) {
		List<Person> people = PeopleDAO.getPeople();
		
		System.out.println("sum of ages");
		System.out.println(people.stream().reduce(0, (sum, p) -> sum += p.age, (sum1, sum2) -> sum1 + sum2));
	}
}