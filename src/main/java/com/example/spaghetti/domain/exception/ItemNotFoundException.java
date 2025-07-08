package com.example.spaghetti.domain.exception;

public class ItemNotFoundException extends EntityNotFoundException {
    public ItemNotFoundException(String id) {
        super("Item with ID '" + id + "' not found.");
    }
}
