package com.github.marcelocure.sandbox.designpatterns.abstractfactory;

import com.github.marcelocure.sandbox.designpatterns.abstractfactory.impl.Circle;
import com.github.marcelocure.sandbox.designpatterns.abstractfactory.impl.Rectangle;
import com.github.marcelocure.sandbox.designpatterns.abstractfactory.impl.Square;

public class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType){

        if(shapeType == null){
            return null;
        }

        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();

        }else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();

        }else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }

        return null;
    }

    @Override
    Color getColor(String color) {
        return null;
    }
}