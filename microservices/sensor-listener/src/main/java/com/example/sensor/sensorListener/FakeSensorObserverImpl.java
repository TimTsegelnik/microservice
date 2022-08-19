package com.example.sensor.sensorListener;

import com.example.sensor.sensorDao.SensorData;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

@Component
public class FakeSensorObserverImpl implements SensorObserver {

    private static final String SENSOR_ID = "FakeSensorId@123";
    private static final int MAX_GENERATED_VALUE = 100;
    private final Random random = new Random();

    @Override
    public SensorData getDataFromServer() {
        return new SensorData(SENSOR_ID, random.nextInt(MAX_GENERATED_VALUE), LocalDateTime.now());
    }
}
