package com.example.sensorlistener.controller;


import com.example.sensorlistener.domein.Sensor;
import com.example.sensorlistener.service.SensorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/sensor-listener")
@AllArgsConstructor
@Slf4j
public class SensorController {
    private final SensorService sensorService;

    @GetMapping
    public Page<Sensor> getAllSensors(
            Pageable page
    ) {
        log.info("SensorController Get: /audit/v1/sensors/  page: {}", page);
        return sensorService.findAll(page);
    }

    @GetMapping("/between")
    public Page<Sensor> findSensorsBetween(
            @RequestParam("startWith") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startWith,
            @RequestParam("endWith") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endWith,
            Pageable page
    ) {
        log.info("SensorController Get: /audit/v1/sensors/between/ startWith={}, endWith={}, pageable={}", startWith, endWith, page);
        return sensorService.findSensorsBetween(page, startWith, endWith);
    }
}
