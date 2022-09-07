package com.example.gatewayservice.controller;

import com.example.gatewayservice.client.AuditClient;
import com.example.gatewayservice.dto.Sensor;
import com.example.gatewayservice.dto.Views;
import com.example.gatewayservice.validation.PageableMaxSize;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

import static com.example.gatewayservice.validation.ValidationPattern.DATE_TIME;
import static com.example.gatewayservice.validation.ValidationPattern.SENSOR_STATUS;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("gate/v1/audit")
@AllArgsConstructor
@Validated
public class AuditController {

    private final AuditClient auditClient;


    @GetMapping(path = "/{status}", produces = APPLICATION_JSON_VALUE)
    @JsonView({Views.SensorStatus.class})
    public ResponseEntity<List<Sensor>> getSensorDataWithStatus(
            @ApiParam(allowableValues = "NORMAL, LOADED, FAILED")
            @PathVariable("status") @NotNull @Pattern(regexp = SENSOR_STATUS) String status,

            @PageableMaxSize(maxPageSize = 400) @PageableDefault(size = 20) Pageable page
    ) {
        Page<Sensor> sensorWithStatus = auditClient.getAllSensorsWithStatus(status, page);
        return ResponseEntity.ok(sensorWithStatus.getContent());
    }

    @GetMapping(path = "/between/{status}", produces = APPLICATION_JSON_VALUE)
    @JsonView(Views.SensorStatus.class)
    public ResponseEntity<List<Sensor>> findSensorBetween(
            @ApiParam(allowableValues = "NORMAL, LOADED, FAILED")
            @PathVariable("status") @NotNull @Pattern(regexp = SENSOR_STATUS) String status,

            @ApiParam(type = "string", format = "date-time")
            @RequestParam("startWith") @NotNull @Pattern(regexp = DATE_TIME) String startWith,

            @ApiParam(type = "string", format = "date-time")
            @RequestParam("endWith") @NotNull @Pattern(regexp = DATE_TIME) String endWith,

            @PageableMaxSize(maxPageSize = 400) @PageableDefault(size = 20) Pageable page) {
        Page<Sensor> sensorBetween = auditClient.findSensorBetween(status, startWith, endWith, page);
        return ResponseEntity.ok(sensorBetween.getContent());
    }

}
