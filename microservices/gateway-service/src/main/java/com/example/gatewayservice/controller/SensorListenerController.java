package com.example.gatewayservice.controller;

import com.example.gatewayservice.client.SensorListenerClient;
import com.example.gatewayservice.dao.SensorData;
import com.example.gatewayservice.dao.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.format.annotation.DateTimeFormat;
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
    public List<SensorData> getAllSensorsMetrics() {
        return sensorListenerClient.getAllSensors();
    }

    @GetMapping("/between")
    @JsonView(Views.SensorData.class)
    public List<SensorData> findSensorBetween(
            @RequestParam("before") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime before,
            @RequestParam("after") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime after) {
        return sensorListenerClient.findSensorBetween(
                before.toString(),
                after.toString());
    }
}
