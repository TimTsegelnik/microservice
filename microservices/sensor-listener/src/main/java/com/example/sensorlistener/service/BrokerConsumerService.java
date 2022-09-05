package com.example.sensorlistener.service;


import com.example.sensorlistener.service.dto.SensorData;

public interface BrokerConsumerService {
    void listen(SensorData data);
}
