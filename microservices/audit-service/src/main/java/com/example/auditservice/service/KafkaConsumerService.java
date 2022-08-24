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
            groupId = "2"
    )
    void listener(SensorData data) {
        System.out.println(data);
        if (Objects.nonNull(data)) {
            sensorService.save(data);
        }
    }

}

