package com.github.marcelocure.sandbox.designpatterns.factory.impl;

import com.github.marcelocure.sandbox.designpatterns.factory.Shape;

public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}