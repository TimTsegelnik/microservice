package com.example.sensorlistener.service;


import org.springframework.kafka.annotation.KafkaListener;

import java.util.List;

public interface BrokerConsumerService<T> {
    @KafkaListener
    void batchListen(List<T> dataList);

}
