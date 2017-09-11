package com.github.marcelocure.sandbox.designpatterns.objectPool;

public class Program {
    public static void main(String[] args) {
        ConnectionPool pool = new ConnectionPool(10);
        System.out.println("Initial state");
        pool.printConnections();
        ConnectionState connState = pool.getConnection();
        System.out.println("Getting a connection");
        pool.printConnections();
        System.out.println("Returning a connection");
        pool.returnConnection(connState);
        pool.printConnections();
    }
}
