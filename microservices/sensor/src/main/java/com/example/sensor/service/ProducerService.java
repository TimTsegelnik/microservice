package com.example.sensor.service;

import java.util.List;

public interface ProducerService<T> {
    void send(T data);
    void sendBatch(List<T> data);
}
