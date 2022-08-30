package com.example.gatewayservice.controller;

import com.example.gatewayservice.client.SensorListenerClient;
import com.example.gatewayservice.dao.SensorData;
import com.example.gatewayservice.dao.Views;
import com.example.gatewayservice.validation.PageableMaxSize;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("gate/v1/sensors")
public class SensorListenerController {

    private final SensorListenerClient sensorListenerClient;

    public SensorListenerController(SensorListenerClient sensorListenerClient) {
        this.sensorListenerClient = sensorListenerClient;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @JsonView(Views.SensorData.class)
    public ResponseEntity<List<SensorData>> getAllSensorsMetrics(
            @PageableMaxSize(maxPageSize = 400) Pageable pageable
    ) {
        Page<SensorData> allSensors = sensorListenerClient.getAllSensors(pageable);
        return ResponseEntity.ok(allSensors.getContent());
    }

    @GetMapping(path = "/between", produces = APPLICATION_JSON_VALUE)
    @JsonView(Views.SensorData.class)
    public ResponseEntity<List<SensorData>> findSensorBetween(
            @RequestParam("startWith") LocalDateTime startWith,
            @RequestParam("endWith") LocalDateTime endWith,
            @PageableMaxSize(maxPageSize = 400) Pageable page) {
        Page<SensorData> sensorBetween = sensorListenerClient.findSensorBetween(startWith, endWith, page);
        return ResponseEntity.ok(sensorBetween.getContent());
    }
}
