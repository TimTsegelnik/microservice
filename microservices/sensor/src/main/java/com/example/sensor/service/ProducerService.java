package com.example.sensor.service;

import com.example.sensor.domein.SensorData;

public interface ProducerService {
    void send(SensorData data);
}
