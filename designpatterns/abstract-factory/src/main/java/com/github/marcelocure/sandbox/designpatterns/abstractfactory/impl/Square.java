package com.github.marcelocure.sandbox.designpatterns.abstractfactory.impl;

import com.github.marcelocure.sandbox.designpatterns.abstractfactory.Shape;

public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}