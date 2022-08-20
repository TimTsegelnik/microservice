package com.example.auditservice.service;

import com.example.auditservice.sensorDao.SensorData;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class KafkaConsumerService {
    private final SensorService sensorService;

    @KafkaListener(
            topics = "sensor",
            groupId = "1",
            containerFactory = "kafkaConsumerSensorFactory"
    )
    void listener(SensorData data) {
        if (Objects.nonNull(data)) {
            sensorService.save(data);
        }
    }

}