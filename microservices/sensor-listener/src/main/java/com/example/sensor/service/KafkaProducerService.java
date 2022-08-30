package com.example.sensor.service;

import com.example.sensor.sensorDao.SensorData;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@AllArgsConstructor
@Slf4j
public class KafkaProducerService {
    private static final String TOPIC_NAME = "sensor";

    private final KafkaTemplate<String, SensorData> kafkaTemplate;

    public void send(SensorData sensorData) {
        ListenableFuture<SendResult<String, SensorData>> future = kafkaTemplate.send(TOPIC_NAME, sensorData);
        future.addCallback(new ListenableFutureCallback<SendResult<String, SensorData>>() {
            @Override
            public void onFailure(Throwable  ex) {
                log.error("unable to send data: {} with exception: {}", sensorData, ex);
            }

            @Override
            public void onSuccess(SendResult<String, SensorData> result) {
                log.info("send data: {} , with offset: {}", sensorData, result.getRecordMetadata().offset());
            }
        });
    }

}
