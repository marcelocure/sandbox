package com.github.marcelocure.sandobox.designpatterns.builder;

public class Program {
    public static void main(String[] args) {
        PhoneBuilder phoneBuilder = new PhoneBuilder();
        Phone phone = phoneBuilder.createPhone().withProcessor("quadcore")
                .withRam("4gb")
                .withStorage("32gb")
                .withCamera("12mpx")
                .build();
        System.out.println(phone.toString());
    }
}
