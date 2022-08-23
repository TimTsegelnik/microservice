package com.example.auditservice.sensorDao;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SensorData {
    private String sensorId;
    private Integer sensorData;
    private LocalDateTime dateTime;
}

