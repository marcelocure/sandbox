package com.github.marcelocure.sandbox.java8.newfeatures;

import java.util.Arrays;
import java.util.List;

public class PeopleDAO {
	public static List<Person> getPeople(){
		return Arrays.asList(new Person(1, "adão", 46),
							 new Person(2, "barbara", 24),
							 new Person(3, "claudia", 32),
							 new Person(4, "daniel", 26),
							 new Person(5, "edevaldo", 55),
						 	 new Person(6, "fabio", 38),
							 new Person(7, "gabriela", 21),
							 new Person(8, "humberto", 36),
							 new Person(9, "igor", 27),
							 new Person(10, "jaqueline", 30),
							 new Person(11, "karina", 23),
							 new Person(12, "luiza", 19),
							 new Person(13, "marcelo", 26),
							 new Person(14, "nadia", 57),
							 new Person(15, "olivia", 68),
							 new Person(16, "paulo", 36),
							 new Person(17, "quaresma", 89),
							 new Person(18, "rafaela", 22),
							 new Person(19, "sandra", 22),
							 new Person(20, "tatiana", 21),
							 new Person(21, "ursula", 25),
							 new Person(22, "valeria",29),
							 new Person(23, "werley",35),
							 new Person(24, "xuxa", 40),
							 new Person(25, "yuri", 29),
							 new Person(26, "zuleica", 54));
	}
}
