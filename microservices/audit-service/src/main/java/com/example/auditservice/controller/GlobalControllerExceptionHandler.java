package com.example.auditservice.controller;

import com.example.auditservice.domein.SensorStatus;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class GlobalControllerExceptionHandler {
    @ExceptionHandler(ConversionFailedException.class)
    public ResponseEntity<String> handleIllegalSensorStatusValue() {
        return ResponseEntity.status(BAD_REQUEST)
                .body("Status must be: " + Stream.of(SensorStatus.values())
                        .map(SensorStatus::name)
                        .collect(joining(", ")));
    }
}
