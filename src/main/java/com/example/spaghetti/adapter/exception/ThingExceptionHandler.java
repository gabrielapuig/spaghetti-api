package com.example.spaghetti.adapter.exception;

import com.example.spaghetti.domain.exception.ThingNotFoundException;
import com.example.spaghetti.adapter.controller.ThingController;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@ControllerAdvice(assignableTypes = ThingController.class)
public class ThingExceptionHandler {

    @ExceptionHandler(ThingNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleThingNotFound(ThingNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", ex.getMessage()));
    }
}
