package com.example.auditservice.controller;

import com.example.auditservice.domein.Sensor;
import com.example.auditservice.domein.SensorStatus;
import com.example.auditservice.service.SensorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/audit")
@AllArgsConstructor
@Slf4j
public class SensorController {
    private final SensorService sensorService;

    @GetMapping("/{status}")
    public Page<Sensor> getAllSensorsWithStatus(
            @PathVariable("status") SensorStatus status,
            Pageable page
    ) {
        log.info("SensorController Get: /audit/v1/sensors/{status} with status={}, {}", status, page);
        return sensorService.findByStatus(page, status);
    }

    @GetMapping("/between/{status}")
    public Page<Sensor> findSensorsBetween(
            @PathVariable("status") SensorStatus status,
            @RequestParam("startWith") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startWith,
            @RequestParam("endWith") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endWith,
            Pageable page
    ) {
        log.info("SensorController Get: /audit/v1/sensors/between/{} startWith={}, endWith={}, pageable={}",status, startWith, endWith, page);
        return sensorService.findSensorsBetween(status, startWith, endWith, page);
    }
}
