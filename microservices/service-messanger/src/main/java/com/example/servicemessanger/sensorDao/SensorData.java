package com.example.servicemessanger.sensorDao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SensorData {
    private  String sensorId;
    private  Integer sensorData;
    private  LocalDateTime dateTime;

}

