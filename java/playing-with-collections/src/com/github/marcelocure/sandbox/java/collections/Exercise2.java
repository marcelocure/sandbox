package com.github.marcelocure.sandbox.java.collections;

import java.util.*;

public class Exercise2{
	 
    public static void main(String[] args) {
        SortedSet s = new TreeSet(new ArgsComparator());
        for (String a : args) s.add(a);
        System.out.println(s.size() + " distinct words: " + s);
    }
}
