package com.example.gatewayservice.controller.exceptionHandlers.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


@Data
@Builder
public class ErrorsDto {
    private HttpStatus httpStatus;

    private LocalDateTime timestamp;

    private String message;

    private String details;
}
