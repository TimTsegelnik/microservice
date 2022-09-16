package com.example.gatewayservice.controller.exception_handlers;

import com.example.gatewayservice.controller.exception_handlers.dto.ErrorsDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class RestExceptionHandlers extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorsDto error = ErrorsDto.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .message("Validation Error")
                .timestamp(LocalDateTime.now())
                .details(ex.getBindingResult().toString())
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object> handleConstraintExceptions(ConstraintViolationException ex, WebRequest request) {
        ErrorsDto constraintError = ErrorsDto.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .message("Constraint Error")
                .timestamp(LocalDateTime.now())
                .details(ex.getMessage())
                .build();

        return new ResponseEntity<>(constraintError, HttpStatus.BAD_REQUEST);
    }

}

