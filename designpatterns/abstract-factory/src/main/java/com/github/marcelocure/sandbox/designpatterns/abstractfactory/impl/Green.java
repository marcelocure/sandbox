package com.github.marcelocure.sandbox.designpatterns.abstractfactory.impl;

import com.github.marcelocure.sandbox.designpatterns.abstractfactory.Color;

public class Green implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}