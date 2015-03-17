package com.github.marcelocure.sandbox.java.collections;

import java.util.Comparator;

public class ArgsComparator implements Comparator<String> {
	@Override
    public int compare(String e1, String e2) {
        return e1.compareToIgnoreCase(e2);
    }
}