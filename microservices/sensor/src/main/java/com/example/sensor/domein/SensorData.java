package com.example.sensor.domein;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class SensorData {
    private String sensorId;
    private Integer sensorData;
    private LocalDateTime dateTime;
}

