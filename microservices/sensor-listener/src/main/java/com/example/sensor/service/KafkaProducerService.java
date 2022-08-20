package com.example.sensor.service;

import com.example.sensor.sensorDao.SensorData;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaProducerService {
    private static final String TOPIC_NAME = "sensor";

    private final KafkaTemplate<String, SensorData> kafkaTemplate;

    public void send(SensorData sensorData) {
        kafkaTemplate.send(TOPIC_NAME, sensorData);
    }

}
