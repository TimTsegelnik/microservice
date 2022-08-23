package com.example.gatewayservice.controller;

import com.example.gatewayservice.client.MessengerServiceClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/gate/v1/count-errors")
public class CounterController {
    private final MessengerServiceClient messengerServiceClient;

    public CounterController(MessengerServiceClient messengerServiceClient) {
        this.messengerServiceClient = messengerServiceClient;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> getSensorData() {
            return ResponseEntity.ok(messengerServiceClient.getExceedSensorData());
    }
}
