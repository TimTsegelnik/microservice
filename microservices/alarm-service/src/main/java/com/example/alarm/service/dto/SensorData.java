package com.example.alarm.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SensorData {
    private  String sensorId;
    private  Integer sensorValue;
    private  LocalDateTime dateTime;
}

