package com.hensoares.interfaces.exceptionhandler;

import com.hensoares.application.mock.exceptions.MockNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MockNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleMockNotFoundException(MockNotFoundException exception){
        final var response = new ErrorDetails(exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
