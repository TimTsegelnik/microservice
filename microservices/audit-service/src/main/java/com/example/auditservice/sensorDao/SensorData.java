package com.example.auditservice.sensorDao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensorData {
    private String sensorId;
    private Integer sensorData;
    private LocalDateTime dateTime;
}

