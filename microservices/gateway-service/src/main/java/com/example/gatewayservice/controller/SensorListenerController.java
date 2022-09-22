package com.example.gatewayservice.controller;

import com.example.gatewayservice.client.SensorListenerClient;
import com.example.gatewayservice.dto.Sensor;
import com.example.gatewayservice.dto.Views;
import com.example.gatewayservice.validation.PageableMaxSize;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

import static com.example.gatewayservice.validation.ValidationPattern.DATE_TIME;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/gate/v1/sensors")
@AllArgsConstructor
@Validated
public class SensorListenerController {

    private final SensorListenerClient sensorListenerClient;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @JsonView(Views.SensorData.class)
    public ResponseEntity<List<Sensor>> getAllSensors(
            @PageableMaxSize(maxPageSize = 400) @PageableDefault(size = 20) @ParameterObject Pageable page
    ){
        Page<Sensor> allSensors = sensorListenerClient.getAllSensors(page);
        return ResponseEntity.ok(allSensors.getContent());
    }

    @GetMapping(path = "/between", produces = APPLICATION_JSON_VALUE)
    @JsonView(Views.SensorData.class)
    public ResponseEntity<List<Sensor>> findSensorBetween(
            @Schema(type = "string", format = "date-time")
            @RequestParam("startWith") @NotNull @Pattern(regexp = DATE_TIME, message = "must be datetime") String startWith,

            @Schema(type = "string", format = "date-time")
            @RequestParam("endWith") @NotNull @Pattern(regexp = DATE_TIME, message = "must be datetime") String endWith,

            @PageableMaxSize(maxPageSize = 400) @PageableDefault(size = 20) @ParameterObject Pageable page) {

        Page<Sensor> sensorBetween = sensorListenerClient.getAllSensorsBetween(startWith, endWith, page);
        return ResponseEntity.ok(sensorBetween.getContent());
    }
}
