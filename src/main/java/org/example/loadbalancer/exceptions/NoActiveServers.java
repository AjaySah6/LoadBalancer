package org.example.loadbalancer.exceptions;

public class NoActiveServers extends RuntimeException{
    public NoActiveServers() {}
    public NoActiveServers(String message) {
        super(message);
    }

}
