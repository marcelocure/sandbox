package com.github.marcelocure.sandbox.java.collections;

import java.util.List;
import java.util.stream.Collectors;

public class Exercise3 {
	public static void main(String[] args) {
		List<String> list = applyTrim(ListDAO.getListWithWhiteSpaces());
		list.forEach(item -> System.out.println(item));
	}
	
	public static List<String> applyTrim(List<String> list){
		return list.stream().map(item -> item.trim()).collect(Collectors.toList());
	}
}
