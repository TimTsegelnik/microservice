package com.example.alarm.service;

import com.example.alarm.service.dto.SensorData;
import org.springframework.kafka.annotation.KafkaListener;

public interface BrokerConsumerService {
    @KafkaListener
    void listen(SensorData data);
}
