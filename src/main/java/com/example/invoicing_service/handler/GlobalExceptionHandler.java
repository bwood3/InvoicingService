package com.example.invoicing_service.handler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalStateException.class)
    //we want a http response back to client (this is wrapper for response)
    public ResponseEntity<?> handleException(IllegalStateException exception)
    {
        //we state we have bad request, and add body with exception message
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    //to handle invalid entry (Ex. null name) <-See Customer.java
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleException(MethodArgumentNotValidException exception)
    {
        //from total list of errors -> we want to find message
        String errorMessage = exception.getBindingResult().getFieldErrors().stream().map(error -> error.getDefaultMessage())
                .collect(Collectors.joining(","));

        return ResponseEntity.badRequest().body(errorMessage);
    }



}

