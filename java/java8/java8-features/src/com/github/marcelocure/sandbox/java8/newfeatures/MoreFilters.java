package com.github.marcelocure.sandbox.java8.newfeatures;

import java.io.File;

public class MoreFilters {
	public static void main(String[] args) {
		System.out.println("Python files");
		FileDAO.getFiles().stream().filter(MoreFilters::fileIsPython).forEach(System.out::println);
		
		System.out.println("Ruby files");
		FileDAO.getFiles().stream().filter(MoreFilters::fileIsRuby).forEach(System.out::println);;
		
		System.out.println("Java files");
		FileDAO.getFiles().stream().filter(MoreFilters::fileIsJava).forEach(System.out::println);;
	}
	
	public static boolean fileIsPython(File file) {
		return file.getAbsolutePath().endsWith("py") ? true : false;
	}

	public static boolean fileIsRuby(File file) {
		return file.getAbsolutePath().endsWith("rb") ? true : false;
	}

	public static boolean fileIsJava(File file) {
		return file.getAbsolutePath().endsWith("java") ? true : false;
	}
}