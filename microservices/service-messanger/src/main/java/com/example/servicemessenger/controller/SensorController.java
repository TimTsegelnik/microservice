package com.example.servicemessenger.controller;

import com.example.servicemessenger.service.SensorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/sensors")
@AllArgsConstructor
public class SensorController {

    private final SensorService sensorService;

    @GetMapping("/count")
    public ResponseEntity<Long> getCountOfExceedSensorValue() {
        return ResponseEntity
                .ok(sensorService.countExceedValue());
    }
}