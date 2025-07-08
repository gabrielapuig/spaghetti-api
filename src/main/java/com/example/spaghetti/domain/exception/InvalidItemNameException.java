package com.example.spaghetti.domain.exception;

public class InvalidItemNameException extends RuntimeException {

    public InvalidItemNameException(String name) {
        super("Item name must start with an uppercase letter: " + name);
    }
}
