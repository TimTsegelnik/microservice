package com.example.sensor.service;

import com.example.sensor.domein.SensorData;

import java.util.List;

public interface SensorService {
    SensorData getSensorData();
    List<SensorData> getBatchSensorData(Integer batchSize);
}
