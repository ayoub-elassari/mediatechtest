package com.example.mediatech.exception;

public class EntityAllReadyExistsException extends RuntimeException{
    public EntityAllReadyExistsException() {
    }

    public EntityAllReadyExistsException(String message) {
        super(message);
    }
}
