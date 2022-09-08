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

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProducerServiceImpl implements ProducerService<SensorData> {

    private final KafkaTemplate<String, SensorData> kafkaTemplate;

    @Override
    public void send(SensorData data) {
        getResultLog(kafkaTemplate.sendDefault(data));
    }

    @Override
    public void sendBatch(List<SensorData> data) {
        data.stream()
                .map(kafkaTemplate::sendDefault)
                .forEach(ProducerServiceImpl::getResultLog);
    }

    private static void getResultLog( ListenableFuture<SendResult<String, SensorData>> future) {
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("unable to send data", ex);
            }

            @Override
            public void onSuccess(SendResult<String, SensorData> result) {
                log.info("send data: {} , with offset: {}", result.getProducerRecord().value(), result.getRecordMetadata().offset());
            }
        });
    }
}
