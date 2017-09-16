package com.github.marcelocure.sandbox.designpatterns.command;

class DomesticEngineer implements Command {
    public void execute() {
        System.out.println("take out the trash");
    }
}