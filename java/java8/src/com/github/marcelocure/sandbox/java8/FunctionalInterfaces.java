package com.github.marcelocure.sandbox.java8;

public class FunctionalInterfaces {

	@FunctionalInterface
	public interface Speaker {
		public void speak();
	}

	public static void main(String[] args) {
		speakHello();
		speakGoodbye();
	}
	
	public static void speakHello(){
		Speaker speaker = () -> System.out.println("Hello");
		speaker.speak();
	}
	
	public static void speakGoodbye(){
		Speaker speaker = () -> System.out.println("Goodbye");
		speaker.speak();
	}
}