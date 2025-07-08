package com.example.spaghetti.domain.exception;

public class ThingNotFoundException extends EntityNotFoundException {
    public ThingNotFoundException(String id) {
        super("Thing with ID '" + id + "' not found.");
    }
}
