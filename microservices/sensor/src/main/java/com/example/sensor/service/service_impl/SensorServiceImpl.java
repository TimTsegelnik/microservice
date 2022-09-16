package com.example.sensor.service.service_impl;

import com.example.sensor.domein.SensorData;
import com.example.sensor.service.SensorService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
public class SensorServiceImpl implements SensorService {
    private static final String SENSOR_ID = "FakeSensorId@123";
    private static final int MAX_GENERATED_VALUE = 100;

    private final Random random = new Random();

    @Override
    public SensorData getSensorData() {
        return createFakeSensorMetrics();
    }

    @Override
    public List<SensorData> getBatchSensorData(Integer batchSize) {
        return Stream.generate(this::createFakeSensorMetrics)
                .limit(batchSize)
                .toList();
    }

    private SensorData createFakeSensorMetrics() {
        return new SensorData(
                SENSOR_ID,
                random.nextInt(MAX_GENERATED_VALUE),
                LocalDateTime.now());
    }
}
