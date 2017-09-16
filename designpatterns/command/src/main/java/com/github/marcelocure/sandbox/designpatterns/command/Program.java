package com.github.marcelocure.sandbox.designpatterns.command;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static List produceRequests() {
        List<Command> queue = new ArrayList<>();
        queue.add(new DomesticEngineer());
        queue.add(new Politician());
        queue.add(new Programmer());
        return queue;
    }

    public static void workOffRequests(List<Command> queue) {
        for (Command command : queue) {
            command.execute();
        }
    }

    public static void main( String[] args ) {
        List queue = produceRequests();
        workOffRequests(queue);
    }
}
