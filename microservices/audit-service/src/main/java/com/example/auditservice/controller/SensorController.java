package com.example.auditservice.controller;

import com.example.auditservice.domein.Sensor;
import com.example.auditservice.domein.SensorStatus;
import com.example.auditservice.service.SensorService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/audit/v1/sensors")
@AllArgsConstructor
public class SensorController {

    private final SensorService sensorService;

    @GetMapping("/{status}")
    public ResponseEntity<List<Sensor>> getAllSensorsWithStatus(
            Pageable page,
            @PathVariable("status")SensorStatus status
    ) {
           return ResponseEntity.ok(sensorService.getAllSensorWithStatus(page, status));

    }
}
