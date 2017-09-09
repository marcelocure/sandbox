package com.github.marcelocure.sandbox.designpatterns.abstractfactory.impl;

import com.github.marcelocure.sandbox.designpatterns.abstractfactory.Shape;

public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}