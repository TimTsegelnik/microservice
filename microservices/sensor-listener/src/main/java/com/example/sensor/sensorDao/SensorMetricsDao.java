package com.example.sensor.sensorDao;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SensorMetricsDao {
    @NotBlank(message = "Sensor Identification cannot be null or empty")
    private String sensorId;
    @NotNull(message = "Sensor's value cannot be null")
    @Min(value = 0, message = "Sensor's value cannot be below zero")
    @Max(value = 100, message = "Sensor's value cannot exceed 100")
    private Integer sensorValue;
}
