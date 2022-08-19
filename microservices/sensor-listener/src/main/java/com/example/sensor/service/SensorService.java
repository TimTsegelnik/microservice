package com.example.sensor.service;

import com.example.sensor.sensorDao.SensorData;
import com.example.sensor.sensorListener.SensorObserver;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SensorService {


private final SensorObserver sensorObserver;
    private final KafkaTemplate<String, SensorData> kafkaTemplate;

    public SensorService(SensorObserver sensorObserver, KafkaTemplate<String, SensorData> kafkaTemplate) {
        this.sensorObserver = sensorObserver;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedRate = 1000)
    void generateSensorValue() {
        SensorData currentData = sensorObserver.getDataFromServer();
        kafkaTemplate.send("sensor", currentData);
    }
}
