package com.github.marcelocure.sandbox.designpatterns.abstractfactory.impl;

import com.github.marcelocure.sandbox.designpatterns.abstractfactory.Shape;

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}