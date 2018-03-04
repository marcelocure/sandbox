package com.github.marcelocure.java8optional;

import com.github.marcelocure.java8optional.model.Car;
import com.github.marcelocure.java8optional.model.Model;

import java.util.Arrays;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        Model model = new Model("Palio", 2015);
        Car palio = new Car(8, 160, model);
        Car fiesta = new Car(16, 160, null);

        List<Car> cars = Arrays.asList(palio, fiesta);
        cars.forEach(car -> car.getModel().ifPresent(c -> System.out.println(c.getName())));
    }
}
