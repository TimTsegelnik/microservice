package com.example.sensorlistener.service;


import com.example.sensorlistener.service.dto.SensorData;

import java.util.List;

public interface BrokerConsumerService<T> {
    void batchListen(List<T> dataList);

}
