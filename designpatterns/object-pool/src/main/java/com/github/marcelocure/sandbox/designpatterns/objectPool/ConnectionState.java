package com.github.marcelocure.sandbox.designpatterns.objectPool;

import java.sql.Connection;

public class ConnectionState {
    private int id;
    private Connection connection;
    private boolean isAvailable;

    public ConnectionState(Connection connection, boolean isAvailable, int id) {
        this.connection = connection;
        this.isAvailable = isAvailable;
        this.id = id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getId() {
        return id;
    }
}
