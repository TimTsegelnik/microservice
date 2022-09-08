package com.example.sensor.producer;

import com.example.sensor.domein.SensorData;
import com.example.sensor.service.ProducerService;
import com.example.sensor.service.SensorService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

@Component
@AllArgsConstructor
public class SensorDataScheduledProducer {
    private final SensorService sensorService;
    private final ProducerService<SensorData> producerService;

    @Scheduled(timeUnit = SECONDS, fixedRate = 1)
    public void send(){
        List<SensorData> dataList = sensorService.getBatchSensorData(3);
        producerService.sendBatch(dataList);
    }
}
