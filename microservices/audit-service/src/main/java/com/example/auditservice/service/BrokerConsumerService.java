package com.example.auditservice.service;

import com.example.auditservice.service.dto.SensorData;

public interface BrokerConsumerService {
    void listen(SensorData data);
}
