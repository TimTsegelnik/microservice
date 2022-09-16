package com.example.auditservice.service;

import com.example.auditservice.service.dto.SensorData;
import org.springframework.kafka.annotation.KafkaListener;

public interface BrokerConsumerService {
    @KafkaListener
    void listen(SensorData data);
}
