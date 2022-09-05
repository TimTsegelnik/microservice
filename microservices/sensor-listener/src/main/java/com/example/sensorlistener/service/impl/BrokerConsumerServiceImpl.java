package com.example.sensorlistener.service.impl;


import com.example.sensorlistener.service.BrokerConsumerService;
import com.example.sensorlistener.service.SensorService;
import com.example.sensorlistener.service.dto.SensorData;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class BrokerConsumerServiceImpl implements BrokerConsumerService {
    private final SensorService sensorService;

    @Override
    @KafkaListener(
            topics = "sensor",
            groupId = "3"
    )
    public void listen(SensorData data) {
        if (Objects.nonNull(data)) {
            log.info("SensorData received from Kafka: {}", data);
            sensorService.save(data);
        }
    }
}

