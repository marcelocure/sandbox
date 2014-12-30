package com.github.marcelocure.sandbox.java8.newfeatures;

import static java.lang.System.out;

public class RunnablesAndLambda {
	Runnable runnable1 = () -> out.println("Output of runnable1");
	Runnable runnable2 = () -> out.println("Output of runnable2");

	public static void main(String... args) {
		new RunnablesAndLambda().runnable1.run();
		new RunnablesAndLambda().runnable2.run();
	}
}