package com.example.sensor.service.serviceImpl;

import com.example.sensor.domein.SensorData;
import com.example.sensor.service.ProducerService;
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
public class ProducerServiceImpl implements ProducerService {

    private final KafkaTemplate<String, SensorData> kafkaTemplate;

    @Override
    public void send(SensorData data) {
        ListenableFuture<SendResult<String, SensorData>> future = kafkaTemplate.sendDefault(data);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("unable to send data: {} with exception: {}", data, ex);
            }

            @Override
            public void onSuccess(SendResult<String, SensorData> result) {
                log.info("send data: {} , with offset: {}", data, result.getRecordMetadata().offset());
            }
        });
    }

}
