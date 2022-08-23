package com.example.gatewayservice.controller;

import com.example.gatewayservice.client.SensorListenerClient;
import com.example.gatewayservice.dao.SensorData;
import com.example.gatewayservice.dao.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("gate/v1/sensors")
public class SensorListenerController {

    private final SensorListenerClient sensorListenerClient;

    public SensorListenerController(SensorListenerClient sensorListenerClient) {
        this.sensorListenerClient = sensorListenerClient;
    }

    @GetMapping
    @JsonView(Views.SensorData.class)
    public ResponseEntity<List<SensorData>> getAllSensorsMetrics(Pageable pageable) {
        Page<SensorData> allSensors = sensorListenerClient.getAllSensors(pageable);
        return ResponseEntity.ok(allSensors.getContent());
    }

    @GetMapping("/between")
    @JsonView(Views.SensorData.class)
    public ResponseEntity<List<SensorData>> findSensorBetween(
            Pageable page,
            @RequestParam("startWith") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startWith,
            @RequestParam("endWith") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endWith) {
        Page<SensorData> sensorBetween = sensorListenerClient.findSensorBetween(page, startWith, endWith);
        return ResponseEntity.ok(sensorBetween.getContent());
    }
}
