package com.example.webapimiddletask.exception.handler;

import com.example.webapimiddletask.exception.BookArgumentNotValidException;
import com.example.webapimiddletask.exception.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<String> handleBookNotFoundException(BookNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookArgumentNotValidException.class)
    public ResponseEntity<String> handleBookNotArgumentNotValidException(BookArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
