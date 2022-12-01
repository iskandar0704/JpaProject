package com.example.controller;

import com.example.exception.ItemNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({ItemNotFoundException.class})
    public ResponseEntity<?> handle(ItemNotFoundException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
