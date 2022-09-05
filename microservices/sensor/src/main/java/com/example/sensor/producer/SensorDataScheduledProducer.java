package com.example.sensor.producer;

import com.example.sensor.service.ProducerService;
import com.example.sensor.service.SensorService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static java.util.concurrent.TimeUnit.SECONDS;

@Component
@AllArgsConstructor
public class SensorDataScheduledProducer {
    private final SensorService sensorService;
    private final ProducerService producerService;

    @Scheduled(timeUnit = SECONDS, fixedRate = 1)
    public void send(){
        producerService.send(sensorService.getSensorData());
    }
}
