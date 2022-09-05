package com.example.gatewayservice.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Sensor {
    @JsonView(Views.SensorData.class)
    private String sensorId;
    @JsonView(Views.SensorData.class)
    private Integer sensorData;
    @JsonView(Views.SensorData.class)
    private LocalDateTime dateTime;
    @JsonView(Views.SensorStatus.class)
    private SensorStatus status;

}
