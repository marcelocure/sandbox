package com.github.marcelocure.sandbox.designpatterns.prototype;

import java.util.Arrays;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<String> types = Arrays.asList("tom","dick");
        for (String type : types) {
            Person prototype = Factory.getPrototype(type);
            if (prototype != null) {
                System.out.println(prototype);
            }
        }
    }
}
