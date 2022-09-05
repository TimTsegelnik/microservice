package com.example.alarm.service;

import com.example.alarm.service.dto.SensorData;

public interface BrokerConsumerService {
    void listen(SensorData data);
}
