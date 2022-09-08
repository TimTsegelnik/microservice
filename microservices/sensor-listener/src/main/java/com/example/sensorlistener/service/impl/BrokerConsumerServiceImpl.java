package com.example.sensorlistener.service.impl;


import com.example.sensorlistener.service.BrokerConsumerService;
import com.example.sensorlistener.service.SensorService;
import com.example.sensorlistener.service.dto.SensorData;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class BrokerConsumerServiceImpl implements BrokerConsumerService<SensorData> {
    private final SensorService sensorService;

    @Override
    @KafkaListener(
            topics = "sensor",
            groupId = "3"
    )
    public void batchListen(@Payload List<SensorData> dataList) {
        List<SensorData> sensorData = dataList.stream()
                .filter(Objects::nonNull)
                .toList();

        sensorService.saveAll(sensorData);
    }
}

