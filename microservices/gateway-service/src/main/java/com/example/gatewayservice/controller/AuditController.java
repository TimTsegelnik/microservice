package com.example.gatewayservice.controller;

import com.example.gatewayservice.client.AuditClient;
import com.example.gatewayservice.dao.SensorData;
import com.example.gatewayservice.dao.SensorStatus;
import com.example.gatewayservice.dao.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("gate/v1/audit")
public class AuditController {

    private final AuditClient auditClient;

    public AuditController(AuditClient auditClient) {
        this.auditClient = auditClient;
    }

    @GetMapping("/{status}")
    @JsonView({Views.SensorStatus.class})
    public ResponseEntity<List<SensorData>> getSensorDataWithStatus(
            Pageable page,
            @PathVariable("status") SensorStatus status
    ) {
        Page<SensorData> sensorWithStatus = auditClient.getAllSensorsWithStatus(page, status);
        return ResponseEntity.ok(sensorWithStatus.getContent());
    }
}
