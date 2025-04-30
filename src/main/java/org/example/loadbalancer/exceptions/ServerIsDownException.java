package org.example.loadbalancer.exceptions;

public class ServerIsDownException extends RuntimeException {
    public ServerIsDownException() {}
    public ServerIsDownException(String message) {
        super(message);
    }
}
