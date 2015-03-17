package com.github.marcelocure.sandbox.java.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exercise1 {
//	Write a program that prints its arguments in random order. Do not make a copy of the argument array. Demonstrate how to print out the elements using both streams and the traditional enhanced for statement.

	public static void main(String[] args) {
		List<String> argList = Arrays.asList(args);

		Collections.shuffle(argList);
		printUsingForEach(argList);
		
		Collections.shuffle(argList);
		printUsingStreamForEach(argList);
	}

	private static void printUsingStreamForEach(List<String> argList) {
		System.out.println("printUsingStreamForEach");
		argList.stream().forEach(item -> System.out.println(item));
	}

	private static void printUsingForEach(List<String> argList) {
		System.out.println("printUsingForEach");
		for (String string : argList) System.out.println(string);
	}
}
