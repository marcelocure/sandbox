package com.github.marcelocure.sandbox.designpatterns.command;

class Programmer implements Command {
    public void execute() {
        System.out.println("sell the bugs, charge extra for the fixes");
    }
}