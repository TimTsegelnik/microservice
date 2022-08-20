package com.example.sensor;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SensorService {
    private static final String SENSOR_ID = "FakeSensorId@123";
    private static final int MAX_GENERATED_VALUE = 100;

    private final Random random = new Random();

    public SensorDao createFakeSensorMetrics(){
        return new SensorDao(SENSOR_ID, random.nextInt(MAX_GENERATED_VALUE));
    }
}
