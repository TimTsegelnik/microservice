package com.example.gatewayservice.controller;

import com.example.gatewayservice.client.AlarmServiceClient;
import com.example.gatewayservice.dto.Sensor;
import com.example.gatewayservice.dto.Views;
import com.example.gatewayservice.validation.PageableMaxSize;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/gate/v1/errors")
@AllArgsConstructor
@Validated
public class AlarmController {
    private final AlarmServiceClient alarmServiceClient;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @JsonView(Views.SensorData.class)
    public ResponseEntity<List<Sensor>> getErrorsSensor(
            @PageableMaxSize(maxPageSize = 400) @PageableDefault(size = 20) Pageable page
    ) {
        Page<Sensor> all = alarmServiceClient.getAll(page);
        return ResponseEntity.ok(all.getContent());
    }

    @GetMapping(value = "/count", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> getSensorData() {
        return ResponseEntity.ok(alarmServiceClient.getErrorCount());
    }
}
