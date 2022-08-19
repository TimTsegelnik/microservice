package com.example.gatewayservice.controller;

import com.example.gatewayservice.client.MessangerServiceClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/count")
public class CounterController {
    private final MessangerServiceClient messangerServiceClient;

    public CounterController(MessangerServiceClient messangerServiceClient) {
        this.messangerServiceClient = messangerServiceClient;
    }

    @GetMapping
    public ResponseEntity<Long> getSensorData() {
            return ResponseEntity.ok(messangerServiceClient.getExceedSensorData());

    }
}
