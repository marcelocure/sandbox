package com.github.marcelocure.sandbox.java.collections;

import java.util.ArrayList;
import java.util.List;

public class ListDAO {
	public static List<String> getListWithWhiteSpaces() {
		List<String> list = new ArrayList<String>();
		for(int i = 0 ; i <= 20; i++) list.add(" val" + i);
		return list;
	}
}