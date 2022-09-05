package com.example.sensor.service.serviceImpl;

import com.example.sensor.domein.SensorData;
import com.example.sensor.service.SensorService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class SensorServiceImpl implements SensorService {
    private static final String SENSOR_ID = "FakeSensorId@123";
    private static final int MAX_GENERATED_VALUE = 100;

    private final Random random = new Random();

    @Override
    public SensorData getSensorData() {
        return createFakeSensorMetrics();
    }

    private SensorData createFakeSensorMetrics() {
        return new SensorData(
                SENSOR_ID,
                random.nextInt(MAX_GENERATED_VALUE),
                LocalDateTime.now());
    }
}
