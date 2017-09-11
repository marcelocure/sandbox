package com.github.marcelocure.sandbox.designpatterns.objectPool;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConnectionPool {
    private int poolSize;
    private List<ConnectionState> connections;

    public ConnectionPool(int poolSize) {
        this.poolSize = poolSize;
        this.connections = buildConnectionPool(poolSize);
    }

    private List<ConnectionState> buildConnectionPool(int poolSize) {
        List<ConnectionState> connections = new ArrayList<ConnectionState>();
        for (int i = 1 ; i < poolSize; i++) {
            connections.add(new ConnectionState(null, true, i));
        }
        return connections;
    }

    public ConnectionState getConnection() {
        ConnectionState connectionState = connections.stream().filter(conn -> conn.isAvailable())
                .collect(Collectors.toList()).get(0);
        connectionState.setAvailable(false);
        return connectionState;
    }

    public void returnConnection(ConnectionState returningConnection) {
        ConnectionState connectionState = connections.stream().filter(conn -> conn.getId() == returningConnection.getId())
                .collect(Collectors.toList()).get(0);
        connectionState.setAvailable(true);
    }

    public void printConnections() {
        for (ConnectionState connectionState:connections) {
            System.out.println("id: " + connectionState.getId() + " available: " + connectionState.isAvailable());;
        }
    }
}
