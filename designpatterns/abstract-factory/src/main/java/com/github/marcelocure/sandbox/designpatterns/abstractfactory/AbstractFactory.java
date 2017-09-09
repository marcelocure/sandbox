package com.github.marcelocure.sandbox.designpatterns.abstractfactory;

public abstract class AbstractFactory {
    abstract Color getColor(String color);
    abstract Shape getShape(String shape) ;
}