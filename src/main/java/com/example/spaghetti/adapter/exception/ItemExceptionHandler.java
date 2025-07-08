package com.example.spaghetti.adapter.exception;

import com.example.spaghetti.domain.exception.InvalidItemNameException;
import com.example.spaghetti.domain.exception.ItemNotFoundException;
import com.example.spaghetti.adapter.controller.ItemController;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@ControllerAdvice(assignableTypes = ItemController.class)
public class ItemExceptionHandler {

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleItemNotFound(ItemNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", ex.getMessage()));
    }

    @ExceptionHandler(InvalidItemNameException.class)
    public ResponseEntity<Map<String, String>> handleInvalidName(InvalidItemNameException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("error", ex.getMessage()));
    }
}
