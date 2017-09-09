package com.github.marcelocure.sandbox.designpatterns.abstractfactory;

import com.github.marcelocure.sandbox.designpatterns.abstractfactory.impl.Blue;
import com.github.marcelocure.sandbox.designpatterns.abstractfactory.impl.Green;
import com.github.marcelocure.sandbox.designpatterns.abstractfactory.impl.Red;

public class ColorFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType){
        return null;
    }

    @Override
    Color getColor(String color) {

        if(color == null){
            return null;
        }

        if(color.equalsIgnoreCase("RED")){
            return new Red();

        }else if(color.equalsIgnoreCase("GREEN")){
            return new Green();

        }else if(color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }

        return null;
    }
}