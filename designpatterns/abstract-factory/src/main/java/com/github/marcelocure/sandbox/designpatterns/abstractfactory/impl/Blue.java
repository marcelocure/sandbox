package com.github.marcelocure.sandbox.designpatterns.abstractfactory.impl;

import com.github.marcelocure.sandbox.designpatterns.abstractfactory.Color;

public class Blue implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}