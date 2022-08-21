package com.example.sensor.controller;

import com.example.sensor.sensorDao.SensorData;
import com.example.sensor.service.SensorService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/sensor-listener/v1/sensors")
@AllArgsConstructor
public class SensorController {

    private final SensorService sensorService;

    @GetMapping
    public ResponseEntity<Page<SensorData>> getAllSensors(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        return ResponseEntity.ok(sensorService.findAllSensors(page, size));
    }

    @GetMapping("/between")
    public ResponseEntity<Page<SensorData>> findSensorsBetween(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam("startWith") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startWith,
            @RequestParam("endWith") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endWith
    ) {
        return ResponseEntity.ok(sensorService.findAllSensorsBetween(page, size, startWith, endWith));
    }

}
